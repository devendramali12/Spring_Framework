const API = 'http://localhost:8080/api/expenses';
let pieChart = null;
let barChart = null;

// ─── On Page Load ────────────────────────────────────────
document.addEventListener('DOMContentLoaded', () => {
    loadExpenses();
    loadCharts();
    loadGrandTotal();
    // Set today's date as default
    document.getElementById('date').value = new Date().toISOString().split('T')[0];
});

// ─── LOAD ALL EXPENSES ───────────────────────────────────
async function loadExpenses(url = API) {
    const res = await fetch(url);
    const data = await res.json();
    renderTable(data);
}

// ─── RENDER TABLE ────────────────────────────────────────
function renderTable(expenses) {
    const tbody = document.getElementById('expenseTableBody');
    if (expenses.length === 0) {
        tbody.innerHTML = `<tr><td colspan="7" style="text-align:center;color:#aaa;padding:30px">No expenses found</td></tr>`;
        return;
    }
    tbody.innerHTML = expenses.map((e, i) => `
        <tr>
            <td>${i + 1}</td>
            <td><strong>${e.title}</strong></td>
            <td>₹${e.amount.toFixed(2)}</td>
            <td><span class="badge badge-${e.category}">${e.category}</span></td>
            <td>${e.date}</td>
            <td>${e.description || '—'}</td>
            <td>
                <button class="btn-edit"   onclick="editExpense(${e.id})">✏️ Edit</button>
                <button class="btn-delete" onclick="deleteExpense(${e.id})">🗑️ Delete</button>
            </td>
        </tr>
    `).join('');
}

// ─── SAVE (Create or Update) ─────────────────────────────
async function saveExpense() {
    const id = document.getElementById('expenseId').value;
    const expense = {
        title:       document.getElementById('title').value.trim(),
        amount:      parseFloat(document.getElementById('amount').value),
        category:    document.getElementById('category').value,
        date:        document.getElementById('date').value,
        description: document.getElementById('description').value.trim()
    };

    if (!expense.title || !expense.amount || !expense.category || !expense.date) {
        alert('Please fill all required fields!');
        return;
    }

    const method = id ? 'PUT' : 'POST';
    const url    = id ? `${API}/${id}` : API;

    const res = await fetch(url, {
        method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(expense)
    });

    if (res.ok) {
        resetForm();
        loadExpenses();
        loadCharts();
        loadGrandTotal();
    } else {
        const err = await res.json();
        alert('Error: ' + JSON.stringify(err));
    }
}

// ─── EDIT ────────────────────────────────────────────────
async function editExpense(id) {
    const res  = await fetch(`${API}/${id}`);
    const data = await res.json();

    document.getElementById('expenseId').value   = data.id;
    document.getElementById('title').value        = data.title;
    document.getElementById('amount').value       = data.amount;
    document.getElementById('category').value     = data.category;
    document.getElementById('date').value         = data.date;
    document.getElementById('description').value  = data.description || '';
    document.getElementById('formTitle').textContent = '✏️ Edit Expense';

    window.scrollTo({ top: 0, behavior: 'smooth' });
}

// ─── DELETE ──────────────────────────────────────────────
async function deleteExpense(id) {
    if (!confirm('Are you sure you want to delete this expense?')) return;

    const res = await fetch(`${API}/${id}`, { method: 'DELETE' });
    if (res.ok) {
        loadExpenses();
        loadCharts();
        loadGrandTotal();
    }
}

// ─── RESET FORM ──────────────────────────────────────────
function resetForm() {
    document.getElementById('expenseId').value   = '';
    document.getElementById('title').value        = '';
    document.getElementById('amount').value       = '';
    document.getElementById('category').value     = '';
    document.getElementById('date').value         = new Date().toISOString().split('T')[0];
    document.getElementById('description').value  = '';
    document.getElementById('formTitle').textContent = '➕ Add Expense';
}

// ─── FILTER ──────────────────────────────────────────────
function applyFilter() {
    const category = document.getElementById('filterCategory').value;
    const start    = document.getElementById('filterStart').value;
    const end      = document.getElementById('filterEnd').value;

    let url = `${API}/filter?`;
    if (category) url += `category=${category}&`;
    if (start)    url += `start=${start}&`;
    if (end)      url += `end=${end}`;

    loadExpenses(url);
}

function clearFilter() {
    document.getElementById('filterCategory').value = '';
    document.getElementById('filterStart').value    = '';
    document.getElementById('filterEnd').value      = '';
    loadExpenses();
}

// ─── GRAND TOTAL ─────────────────────────────────────────
async function loadGrandTotal() {
    const res  = await fetch(`${API}/summary/total`);
    const total = await res.json();
    document.getElementById('grandTotal').textContent = `₹${total.toFixed(2)}`;
}

// ─── CHARTS ──────────────────────────────────────────────
async function loadCharts() {
    await loadPieChart();
    await loadBarChart();
}

async function loadPieChart() {
    const res  = await fetch(`${API}/summary/category`);
    const data = await res.json();

    const labels = Object.keys(data);
    const values = Object.values(data);
    const colors = ['#667eea','#f093fb','#4facfe','#43e97b','#fa709a','#fee140','#a18cd1'];

    if (pieChart) pieChart.destroy();

    const ctx = document.getElementById('pieChart').getContext('2d');
    pieChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels,
            datasets: [{ data: values, backgroundColor: colors, borderWidth: 2 }]
        },
        options: {
            responsive: true,
            plugins: { legend: { position: 'bottom' } }
        }
    });
}

async function loadBarChart() {
    const year = new Date().getFullYear();
    const res  = await fetch(`${API}/summary/monthly?year=${year}`);
    const data = await res.json();

    if (barChart) barChart.destroy();

    const ctx = document.getElementById('barChart').getContext('2d');
    barChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: Object.keys(data),
            datasets: [{
                label: `Monthly Spending ${year}`,
                data: Object.values(data),
                backgroundColor: 'rgba(102, 126, 234, 0.7)',
                borderColor: '#667eea',
                borderWidth: 2,
                borderRadius: 6
            }]
        },
        options: {
            responsive: true,
            plugins: { legend: { display: false } },
            scales: { y: { beginAtZero: true } }
        }
    });
}