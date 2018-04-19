package ZAir.domain.model;

public enum Seat {

	A1(false), B1(false), C1(false), A2(false), B2(false), C2(false), A3(false), B3(false), C3(false), A4(false), B4(
			false), C4(false), A5(false), B5(false), C5(false), A6(false), B6(false), C6(false), A7(false), B7(
					false), C7(false), A8(false), B8(false), C8(false), A9(false), B9(false), C9(
							false), A10(false), B10(false), C10(false), A11(false), B11(false), C11(false), A12(
									false), B12(false), C12(false), A13(false), B13(false), C13(false), A14(false), B14(
											false), C14(false), A15(false), B15(false), C15(false), A16(false), B16(
													false), C16(false), A17(false), B17(false), C17(false), A18(
															false), B18(false), C18(false), A19(false), B19(false), C19(
																	false), A20(false), B20(false), C20(false);
	private boolean seatValue;

	private Seat(boolean value) {
		seatValue = value;
	}

	public void Book() {
		seatValue = true;
	}
}
