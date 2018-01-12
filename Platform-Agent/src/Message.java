import java.io.Serializable;

/**
 * 
 */

/**
 * @author Michel
 *
 */
public class Message implements Cloneable, Serializable{

	private static final long serialVersionUID = -3066574739461308955L;
	private AgentIdentifier sender;
	private final AgentIdentifier receiver;
	
	public Message(AgentIdentifier receiver) {
		assert receiver != null;
		this.receiver = receiver;
	}
	
	public AgentIdentifier getSender() {
		return this.sender;
	}
	
	void setSender(AgentIdentifier sender) {
		assert sender != null;
		this.sender = sender;
	}
	
	public AgentIdentifier getReceiver() {
		return this.receiver;
	}
	
	@Override
	public Message clone() {
		try {
			return (Message) super.clone();
		}catch (CloneNotSupportedException e) {
			throw new Error(e);
		}
	}
}
