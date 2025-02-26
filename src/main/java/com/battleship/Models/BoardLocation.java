package com.battleship.Models;

public enum BoardLocation {
    A1(0),
    A2(1),
    A3(2),
    A4(3),
    A5(4),
    A6(5),
    A7(6),
    A8(7),
    A9(8),
    A10(9),
    B1(10),
    B2(11),
    B3(12),
    B4(13),
    B5(14),
    B6(15),
    B7(16),
    B8(17),
    B9(18),
    B10(19),
    C1(20),
    C2(21),
    C3(22),
    C4(23),
    C5(24),
    C6(25),
    C7(26),
    C8(27),
    C9(28),
    C10(29),
    D1(30),
    D2(31),
    D3(32),
    D4(33),
    D5(34),
    D6(35),
    D7(36),
    D8(37),
    D9(38),
    D10(39),
    E1(40),
    E2(41),
    E3(42),
    E4(43),
    E5(44),
    E6(45),
    E7(46),
    E8(47),
    E9(48),
    E10(49),
    F1(50),
    F2(51),
    F3(52),
    F4(53),
    F5(54),
    F6(55),
    F7(56),
    F8(57),
    F9(58),
    F10(59),
    G1(60),
    G2(61),
    G3(62),
    G4(63),
    G5(64),
    G6(65),
    G7(66),
    G8(67),
    G9(68),
    G10(69),
    H1(70),
    H2(71),
    H3(72),
    H4(73),
    H5(74),
    H6(75),
    H7(76),
    H8(77),
    H9(78),
    H10(79),
    I1(80),
    I2(81),
    I3(82),
    I4(83),
    I5(84),
    I6(85),
    I7(86),
    I8(87),
    I9(88),
    I10(89),
    J1(90),
    J2(91),
    J3(92),
    J4(93),
    J5(94),
    J6(95),
    J7(96),
    J8(97),
    J9(98),
    J10(99);

    private final int value;

    BoardLocation(int value) {
        this.value = value;
    }

    /**
     * Gets the value of the BoardLocation.
     * 
     * @return The value of the BoardLocation in the Board array.
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets the letter of the BoardLocation.
     * 
     * @return The letter of the BoardLocation as a char.
     */
    public char getLetter() {
        return this.name().charAt(0);
    }

    /**
     * Gets the number of the BoardLocation.
     * 
     * @return The number of the BoardLocation.
     */
    public int getNumber() {
        return Integer.parseInt(this.name().substring(1));
    }

    /**
     * Converts a string to a BoardLocation value.
     * 
     * @param location The string to convert.
     * @return The BoardLocation value.
     */
    public static BoardLocation parseString(String location) {
        return BoardLocation.valueOf(location);
    }

    /**
     * Converts an int to a BoardLocation value.
     * 
     * @param location The int to convert. Must be between 0-99.
     * @return The BoardLocation value.
     */
    public static BoardLocation parseInt(int location) {
        return BoardLocation.values()[location];
    }

    /**
     * Converts a row number to a character.
     * 
     * @param rowNum The row number to convert. Must be between 0-26.
     * @return The character of the row.
     */
    public static char getRowChar(int rowNum) {
        if (rowNum < 0 || rowNum > 26) {
            throw new IllegalArgumentException("Row number must be between 0 and 26");
        }
        return (char) ('A' + rowNum - 1);
    }

    /**
     * Converts a row character to a number.
     * 
     * @param rowChar The row character to convert. Must be between A-Z.
     * @return The number of the row.
     */
    public static int getRowNum(char rowChar) {
        if (rowChar < 'A' || rowChar > 'J') {
            throw new IllegalArgumentException("Row character must be between A and J");
        }
        return rowChar - 'A' + 1;
    }

    /**
     * Generates a random BoardLocation.
     * 
     * @return A random BoardLocation.
     */
    public static BoardLocation randomLocation() {
        return BoardLocation.values()[(int) (Math.random() * 100)];
    }
}
