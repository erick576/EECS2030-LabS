
public class LessThan extends Expression {

	LessThan(int left, int right) {
		super(left, right);
		this.IsInt = false;
	}

	Object getValue() {
		/* Your Task */
		return super.getValue();
	}

	void evaluate() {
		/* Your Task */
		this.value = this.left < this.right;
	}
}
