package com.borrelunde.leetcodesolutions.integer_to_roman;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test to the LeetCode problem: 12. Integer to Roman
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.27
 */
@DisplayName("Integer to Roman")
class SolutionTest {

	final Solution solution = new Solution();

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		int num = 3;
		String expected = "III";
		String actual = solution.intToRoman(num);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		int num = 58;
		String expected = "LVIII";
		String actual = solution.intToRoman(num);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example three")
	void exampleThree() {
		int num = 1994;
		String expected = "MCMXCIV";
		String actual = solution.intToRoman(num);
		assertEquals(expected, actual);
	}

	static Stream<Arguments> providePrincipalNumbers() {
		return Stream.of(
				Arguments.of(1, "I"),
				Arguments.of(5, "V"),
				Arguments.of(10, "X"),
				Arguments.of(50, "L"),
				Arguments.of(100, "C"),
				Arguments.of(500, "D"),
				Arguments.of(1000, "M")
		);
	}

	@ParameterizedTest(name = "Number {0} is Roman numeral {1}")
	@DisplayName("Principal Roman numbers")
	@MethodSource("providePrincipalNumbers")
	void principalRomanNumerals(int num, String expected) {
		String actual = solution.intToRoman(num);
		assertEquals(expected, actual);
	}

	static Stream<Arguments> provideSubtractiveNumbers() {
		return Stream.of(
				Arguments.of(4, "IV"),
				Arguments.of(9, "IX"),
				Arguments.of(40, "XL"),
				Arguments.of(90, "XC"),
				Arguments.of(400, "CD"),
				Arguments.of(900, "CM")
		);
	}

	@ParameterizedTest(name = "Number {0} is Roman numeral {1}")
	@DisplayName("Subtractive Roman numbers")
	@MethodSource("provideSubtractiveNumbers")
	void subtractiveRomanNumerals(int num, String expected) {
		String actual = solution.intToRoman(num);
		assertEquals(expected, actual);
	}

	static Stream<Arguments> provideNumbersFromOneToOneHundred() {
		return Stream.of(
				Arguments.of(1, "I"),
				Arguments.of(2, "II"),
				Arguments.of(3, "III"),
				Arguments.of(4, "IV"),
				Arguments.of(5, "V"),
				Arguments.of(6, "VI"),
				Arguments.of(7, "VII"),
				Arguments.of(8, "VIII"),
				Arguments.of(9, "IX"),
				Arguments.of(10, "X"),
				Arguments.of(11, "XI"),
				Arguments.of(12, "XII"),
				Arguments.of(13, "XIII"),
				Arguments.of(14, "XIV"),
				Arguments.of(15, "XV"),
				Arguments.of(16, "XVI"),
				Arguments.of(17, "XVII"),
				Arguments.of(18, "XVIII"),
				Arguments.of(19, "XIX"),
				Arguments.of(20, "XX"),
				Arguments.of(21, "XXI"),
				Arguments.of(22, "XXII"),
				Arguments.of(23, "XXIII"),
				Arguments.of(24, "XXIV"),
				Arguments.of(25, "XXV"),
				Arguments.of(26, "XXVI"),
				Arguments.of(27, "XXVII"),
				Arguments.of(28, "XXVIII"),
				Arguments.of(29, "XXIX"),
				Arguments.of(30, "XXX"),
				Arguments.of(31, "XXXI"),
				Arguments.of(32, "XXXII"),
				Arguments.of(33, "XXXIII"),
				Arguments.of(34, "XXXIV"),
				Arguments.of(35, "XXXV"),
				Arguments.of(36, "XXXVI"),
				Arguments.of(37, "XXXVII"),
				Arguments.of(38, "XXXVIII"),
				Arguments.of(39, "XXXIX"),
				Arguments.of(40, "XL"),
				Arguments.of(41, "XLI"),
				Arguments.of(42, "XLII"),
				Arguments.of(43, "XLIII"),
				Arguments.of(44, "XLIV"),
				Arguments.of(45, "XLV"),
				Arguments.of(46, "XLVI"),
				Arguments.of(47, "XLVII"),
				Arguments.of(48, "XLVIII"),
				Arguments.of(49, "XLIX"),
				Arguments.of(50, "L"),
				Arguments.of(51, "LI"),
				Arguments.of(52, "LII"),
				Arguments.of(53, "LIII"),
				Arguments.of(54, "LIV"),
				Arguments.of(55, "LV"),
				Arguments.of(56, "LVI"),
				Arguments.of(57, "LVII"),
				Arguments.of(58, "LVIII"),
				Arguments.of(59, "LIX"),
				Arguments.of(60, "LX"),
				Arguments.of(61, "LXI"),
				Arguments.of(62, "LXII"),
				Arguments.of(63, "LXIII"),
				Arguments.of(64, "LXIV"),
				Arguments.of(65, "LXV"),
				Arguments.of(66, "LXVI"),
				Arguments.of(67, "LXVII"),
				Arguments.of(68, "LXVIII"),
				Arguments.of(69, "LXIX"),
				Arguments.of(70, "LXX"),
				Arguments.of(71, "LXXI"),
				Arguments.of(72, "LXXII"),
				Arguments.of(73, "LXXIII"),
				Arguments.of(74, "LXXIV"),
				Arguments.of(75, "LXXV"),
				Arguments.of(76, "LXXVI"),
				Arguments.of(77, "LXXVII"),
				Arguments.of(78, "LXXVIII"),
				Arguments.of(79, "LXXIX"),
				Arguments.of(80, "LXXX"),
				Arguments.of(81, "LXXXI"),
				Arguments.of(82, "LXXXII"),
				Arguments.of(83, "LXXXIII"),
				Arguments.of(84, "LXXXIV"),
				Arguments.of(85, "LXXXV"),
				Arguments.of(86, "LXXXVI"),
				Arguments.of(87, "LXXXVII"),
				Arguments.of(88, "LXXXVIII"),
				Arguments.of(89, "LXXXIX"),
				Arguments.of(90, "XC"),
				Arguments.of(91, "XCI"),
				Arguments.of(92, "XCII"),
				Arguments.of(93, "XCIII"),
				Arguments.of(94, "XCIV"),
				Arguments.of(95, "XCV"),
				Arguments.of(96, "XCVI"),
				Arguments.of(97, "XCVII"),
				Arguments.of(98, "XCVIII"),
				Arguments.of(99, "XCIX"),
				Arguments.of(100, "C")
		);
	}

	@ParameterizedTest(name = "Number {0} is Roman numeral {1}")
	@DisplayName("Roman numerals from one to one hundred")
	@MethodSource("provideNumbersFromOneToOneHundred")
	void romanNumeralsFromOneToOneHundred(int num, String expected) {
		String actual = solution.intToRoman(num);
		assertEquals(actual, expected);
	}
}