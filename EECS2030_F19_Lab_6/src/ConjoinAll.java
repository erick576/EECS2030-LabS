
public class ConjoinAll extends ExpressionCollector {

	public ConjoinAll() {
		super();
		this.isIntCollector = false;
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
			this.o = true;
		}
		if (this.isTypeCorrect() && this.sum.size() != 0) {
			boolean b = helper(0, true);
			this.o = b;
		}
	}

	boolean helper(int n, boolean help) {
		if (help == false) {
			return false;
		}
		if (n == this.sum.size()) {
			return true;
		}
		this.sum.get(n).evaluate();
		help = (boolean) this.sum.get(n).value;
		return helper(n + 1, help);
	}

	Object getValue() {
		return super.getValue();
	}

	Expression[] getExpressions() {
		return super.getExpressions();
	}
}

