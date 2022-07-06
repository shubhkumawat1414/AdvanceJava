package Marksheet;

public class MarksheetBean {
	private int Id;
	private String rollno;
	private String name;
	private int physics;
	private int Chemistry;
	private int maths;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public MarksheetBean() {}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getChemistry() {
		return Chemistry;
	}

	public void setChemistry(int chemistry) {
		Chemistry = chemistry;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}
	
}