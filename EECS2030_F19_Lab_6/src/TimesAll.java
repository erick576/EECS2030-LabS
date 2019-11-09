
public class TimesAll extends ExpressionCollector {

	public TimesAll() {
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
			this.o = 1;
		}
		if (this.isTypeCorrect() && this.sum.size() != 0) {
			int sum1 = 1;
			for (Expression e : this.sum) {
				e.evaluate();
				sum1 *= (int) e.value;
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
