import java.lang.ref.WeakReference;

/**
 * 
 */

/**
 * @author Michel
 *
 */
public abstract class Agent {

	private final AgentIdentifier id;
	
	public Agent() {
		this(new AgentIdentifier());
	}
	
	public Agent(AgentIdentifier agentIdentifier) {
		// TODO Auto-generated constructor stub
		assert agentIdentifier != null;
		this.id = agentIdentifier;
		this.id.attachAgent(this);
	}

	public AgentIdentifier getId() {
		return this.id;
	}
	
	public void onStart() {
		//by default do nothing
	}
	
	public abstract void run();
	
	public void onStop() {
		//by default do nothing
	}
	
	//PRIVATE API
	
	private WeakReference<Kernel> kernel;
	
	private Kernel getKernel() {
		return this.kernel.get();
	}
	
	void attachToKernel(Kernel kernel) {
		this.kernel = new WeakReference<Kernel>(kernel);
	}
	
	protected final void commitSuicide() {
		getKernel().killAgent(getId());
	}
	
	private MessageTransport getMTS() {
		return getKernel().getMTS();
	}
	
	private final MailBox mailbox = new MailBox();
	
	MailBox getMailBox() {
		return this.mailbox;
	}

	protected final Message readNextMessage() {
		return getMailBox().read();
	}
	
	protected final void sendMessage(Message message) {
		message.setSender(this.id);
		getMTS().send(message);
	}

	private boolean started = false;
	
	public boolean isStart() {
		return this.started;
	}
	
	public void start() {
		this.started = true;
	}
}
