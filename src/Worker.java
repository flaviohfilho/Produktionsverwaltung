/**
 * @author lahingm
 * @review Flavio
 *Class Worker erbt von Class Person und Contact
 *
 */
public class Worker extends Person {

	private int workerID;
	private WorkerStatus status = WorkerStatus.FREE;

	/**
	 * @param workerID
	 * @param name
	 * @param firstname
	 * @param birthday
	 * @param mail
	 * @param tel
	 * @param street
	 * @param housenumber
	 * @param zipID
	 */
	 public Worker( int workerID, String name, String firstname, String birthday, String mail, String tel, String street,
					String housenumber, String zipID ) {
		
		 super(name,firstname,birthday,mail,tel,street,housenumber,zipID);
		 this.workerID = workerID;

	 }

	public WorkerStatus getStatus() {
		return status;
	}

	public void setStatus(WorkerStatus status) {
		this.status = status;
	}
}
