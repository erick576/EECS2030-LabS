
public class AddAll extends ExpressionCollector {

	public AddAll() {
		super();
		this.isIntCollector = true;
	}

	void addExpression(int left, String op, int right) {
		super.addExpression(left, op, right);
	}

	boolean isTypeCorrect() {
		return super.isTypeCorrect();
	}

	void evaluate() {
		/* Your Task */
		if (this.sum.size() == 0) {
			this.o = 0;
		}
		if (this.isTypeCorrect() && this.sum.size() != 0) {
			int sum1 = 0;
			for (Expression e : this.sum) {
				e.evaluate();
				sum1 += (int) e.value;
			}
			this.o = sum1;
		}
	}

	Object getValue() {
		return super.getValue();
	}

	Expression[] getExpressions() {
		return super.getExpressions();
	}

}
