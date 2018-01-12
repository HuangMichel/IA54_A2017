/**
 * 
 */

/**
 * @author Michel
 *
 */
public class Kernel implements Runnable{

	private final MessageTransport mts;
	private final AgentRepository repository;
	private final Scheduler scheduler;
	
	public Kernel() {
		this.mts = new MessageTransport(this);
		this.repository = new AgentRepository();
		this.scheduler = new Scheduler(this);
	}
	
	void killAgent(AgentIdentifier id) {
		final Agent ag = getAgentRepository().get(id);
		if(ag != null) {
			try {
				ag.onStop();
			}finally {
				ag.attachToKernel(null);
				getAgentRepository().remove(id);
				id.attachAgent(null);
			}
		}
		
	}

	public MessageTransport getMTS() {
		return this.mts;
	}

	public AgentRepository getAgentRepository() {
		return this.repository;
	}

	public Scheduler getScheduler() {
		return this.scheduler;
	}
	
	public void addAgent(Agent agent) {
		assert agent != null;
		agent.attachToKernel(this);
		getAgentRepository().put(agent.getId(), agent);
	}

	@Override
	public void run() {
		while(!getAgentRepository().isEmpty()) {
			getScheduler().run();
			Thread.yield();
		}
	}
}
