import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.UUID;

/**
 * 
 */

/**
 * @author Michel
 *
 */
public class AgentIdentifier implements Serializable, Cloneable, Comparable<AgentIdentifier>{

	private static final long serialVersionUID = 3161426688221233043L;
	private final UUID id = UUID.randomUUID();
	
	public UUID getUUID() {
		return this.id;
	}

	@Override
	public String toString() {
		return "AgentIdentifier [id=" + id.toString() + "]";
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AgentIdentifier) {
			return getUUID().equals(((AgentIdentifier)obj).getUUID());
		}else if(obj instanceof UUID) {
			return getUUID().equals(obj);
		}
		return false;
	}

	@Override
	public AgentIdentifier clone() {
		try {
			return (AgentIdentifier) super.clone();
		}catch (CloneNotSupportedException e) {
			throw new Error(e);
		}
	}
	
	@Override
	public int compareTo(AgentIdentifier o) {
		if(o == null) {
			return Integer.MIN_VALUE;
		}
		return getUUID().compareTo(o.getUUID());
	}
	
	//PRIVATE API
	private WeakReference<Agent> agent;
	
	Agent getAgent() {
		return this.agent == null ? null : this.agent.get();
	}
	
	void attachAgent(Agent agent) {
		this.agent = agent == null ? null : new WeakReference<>(agent);
	}
}
