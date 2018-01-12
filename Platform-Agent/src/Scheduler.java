import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Michel
 *
 */
public class Scheduler implements Runnable{

	private WeakReference<Kernel> kernel;
	
	public Scheduler(Kernel kernel) {
		assert kernel != null;
		this.kernel = new WeakReference<>(kernel);
	}
	
	protected Kernel getKernel() {
		return this.kernel.get();
	}
	
	@Override
	public void run() {
		final Iterable<Agent> agents = new ArrayList<>(getKernel().getAgentRepository().values());
		for(final Agent ag : agents) {
			if(!ag.isStart()) {
				ag.start();
			}
			ag.run();
		}
	}
	
}
