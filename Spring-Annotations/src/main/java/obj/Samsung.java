package obj;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Samsung implements Mobile {

	@Override
	public void call() {
		System.out.println("Samsung Got a Call");
	}

}
