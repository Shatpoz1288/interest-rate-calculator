
public abstract class FinalProjectLogic {

	private double loan, loanPeriod, interestRate;

	double convertINTERESTRateInMonths, monthlyInterestRate,
			convertYearsToMonth, principal, unpaidBalance;

	public FinalProjectLogic() {
		loan = 5000;
		interestRate = 12;
		loanPeriod = 1;
	}

	public FinalProjectLogic(double loan, double interestRate, double loanPeriod) {
		this.loan = loan;
		this.interestRate = interestRate;
		this.loanPeriod = loanPeriod;
	}

	public double getMonths() { // convertYearsToMonth
		return loanPeriod * 12;
	}

	public double getInterest() { // convertINTERESTRateInMonths
		return (interestRate / 100) / convertYearsToMonth;
	}

	public double getPrincipal() { // principal
		return loan* convertINTERESTRateInMonths* ((Math.pow(1 + convertINTERESTRateInMonths,convertYearsToMonth) / (Math.pow(1 + convertINTERESTRateInMonths, convertYearsToMonth) - 1)));
	}

	public double monthlyInterestRate() {
		return loan * convertINTERESTRateInMonths;
	}

	public double unpaidBalance() {
		return loan - principal;
	}
}
