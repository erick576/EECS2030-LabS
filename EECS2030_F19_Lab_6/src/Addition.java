
public class Addition extends Expression {

	Addition(int left, int right) {
		super(left, right);
		this.IsInt = true;
	}

	Object getValue() {
		/* Your Task */
		return super.getValue();
	}

	void evaluate() {
		/* Your Task */
		this.value = this.left + this.right;
	}

}
