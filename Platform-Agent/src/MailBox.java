import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Michel
 *
 */
public class MailBox extends ArrayList<Message>{

	private static final long serialVersionUID = -3667076635065441877L;

	public Message read() {
		if(isEmpty()) {
			return null;
		}
		return remove(0);
	}
	
}
