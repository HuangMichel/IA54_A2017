/**
 * 
 */

/**
 * @author Michel
 *
 */
public class PingPongApp {
	public static void main(String[] args) {
		final Kernel kern = new Kernel();
		final Agent pong = new PongAgent();
		final Agent ping = new PingAgent(pong.getId());
		kern.addAgent(ping);
		kern.addAgent(pong);
		kern.run();
	}
	
	private static class PingAgent extends Agent{
		private final AgentIdentifier other;
		public PingAgent(AgentIdentifier id) {
			this.other = id;
		}
		
		@Override
		public void run() {
			final Message msg = readNextMessage();
			final AgentIdentifier aid;
			if(msg != null) {
				System.out.println("rec pong");
				aid = msg.getSender();
			}else {
				aid = this.other;
			}
			System.out.println("send ping");
			sendMessage(new Message(aid));
		}
	}
	
	private static class PongAgent extends Agent {
		public PongAgent() {
			
		}
		
		@Override
		public void run() {
			final Message msg = readNextMessage();
			if(msg != null) {
				System.out.println("rec ping");
				System.out.println("send ping");
				sendMessage(new Message(msg.getSender()));
			}
		}
	}
}
