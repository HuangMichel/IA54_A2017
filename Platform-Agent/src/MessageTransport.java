import java.lang.ref.WeakReference;

/**
 * 
 */

/**
 * @author Michel
 *
 */
public class MessageTransport {

	private final WeakReference<Kernel> kernel;
	
	public MessageTransport(Kernel kernel) {
		assert kernel != null;
		this.kernel = new WeakReference<>(kernel);
	}
	protected Kernel getKernel() {
		return this.kernel.get();
	}
	
	public void send(Message message) {
		// TODO Auto-generated method stub
		assert message != null;
		final AgentIdentifier id = message.getReceiver();
		Agent receiver = id.getAgent();
		if(receiver == null) {
			final AgentRepository repository = getKernel().getAgentRepository();
			receiver = repository.get(message.getReceiver());
			id.attachAgent(receiver);
		}
		if(receiver != null) {
			receiver.getMailBox().add(message);
		}
	}
	
}
