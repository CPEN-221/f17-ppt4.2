CPEN 221 / Fall 2017

Programming Proficiency Test
=========

November 14, 2017

## General Instructions

+ You have 72 minutes (1h 12m) to complete the assigned tasks.
+ Take your time to read the question.
+ Skeleton code can be obtained by cloning this repository. Add JUnit to your build path in Eclipse.
+ Best of luck!

## Submission Instructions

+ Submit your work to the Github classroom repository that was created for your.
+ **Do not alter the directory/folder structure. You should retain the structure as in this repository.**
+ Do not wait until the last minute to push your work to Github. It is a good idea to push your work at intermediate points as well. _I would recommend that you get your Git and Github workflow set up at the start._

## Honour Code

By submitting your work to Github you agree to the following:

+ You did not consult with any other person in completing the examination.
+ You did not aid any other person in the class in completing their examination.
+ If you consulted any external sources, such as resources available on the World Wide Web, in completing the examination then you have cited the source. (You do not need to cite class notes or Sun/Oracle Java documentation.)
+ You are not aware of any infractions of the honour code for this examination.

> Violations of this honour code will be treated as a case of academic misconduct and will dealt with under UBC policies governing such issues. A consequence of this may be to nullify this exam for everyone that submits work for grading!

## Question: Text Formatting
> The skeleton source code for this question is in the package `textformatter`. You may import the provided code as a Gradle project in Eclipse.

`FormattedText` is a datatype that essentially represents a sequence of lines (of text). It has three methods:

1. `boolean add(String line)` that allows one to add a line of text and it returns true (in all cases except when `line` is `null` and `line` is `""`);
2. `String toString()` that returns a `String` representation of the text;
3. `int numlines()` that returns the number of lines of text.

You are given implementations for the first two methods.

Implement the `numlines()` method **using** the given representation for `FormattedText`.

Now, create a subtype of `FormattedText` (by subclassing `FormattedText`) as follows:

+ The new type should be called `CenteredText`.
+ The new type has a public constructor that takes as argument the width of a line of text.
+ Every line that is added to a `CenteredText` object is centered with respect to the line width.
+ Each line of text in `CenteredText` contains exactly one space between words.
+ If a line is longer than the line width then it is split into additional lines such that no line is greater than the line width and no word is split over two lines (and each line is as long as possible).
+ If the spacing needed in a line to center the text is an odd number of spaces then there should be more spaces on the right of the text (strictly one more space) than on the left of the text.
+ If a single word is greater than the width of a line then it should be in a separate line (and it is okay to violate the line width in this case).

For this task, a **word** is a contiguous sequence of characters and words are separated by a space (or multiple white space characters as the case may be -- read the requirements carefully).

### Test Cases

```java
@Test
public void test1() {
	FormattedText text = new FormattedText();
	text.add("abc");
	text.add("defghi");
	assertEquals(2, text.numlines());
}

@Test
public void test2() {
	FormattedText text = new FormattedText();
	assertEquals(0, text.numlines());
}

@Test
public void test3() {
	FormattedText text = new CenteredText(30);
	text.add("Help!");
	text.add("Et tu, Brute?");
	assertEquals(2, text.numlines());
}

@Test
public void test4() {
	FormattedText text = new CenteredText(30);
	text.add("Help!");
	text.add("Et tu, Brute?");
	String expectedOutput = "            Help!             \n" + "        Et tu, Brute?         \n";
	// note that \n denotes a new line
	// and is not considered part of the line width
	assertEquals(expectedOutput, text.toString());
}

@Test
public void test5() {
	FormattedText text = new CenteredText(30);
	text.add("1234567890 1234567890 123456789 012345.");
	String expectedOutput = "    1234567890 1234567890     \n" + "      123456789 012345.       \n";
	assertEquals(expectedOutput, text.toString());
}

@Test
public void test6() {
	FormattedText text = new CenteredText(10);
	text.add("abcdefghijkl");
	String expectedOutput = "abcdefghijkl\n";
	assertEquals(expectedOutput, text.toString());
}

@Test
public void test7() {
	FormattedText text = new CenteredText(10);
	text.add("abcd abcdefghijkl");
	String expectedOutput = "   abcd   \n" + "abcdefghijkl\n";
	assertEquals(expectedOutput, text.toString());
}

@Test
public void test8() {
	FormattedText text = new CenteredText(30);
	text.add("123 456 789 1011 121314 15161718");
	String expectedOutput = "   123 456 789 1011 121314    \n" + "           15161718           \n";
	assertEquals(expectedOutput, text.toString());
	assertEquals(2, text.numlines());
}

@Test
public void test9() {
	FormattedText text = new CenteredText(11);
	text.add("111");
	text.add("222");
	text.add("333");
	text.add("4444444");
	String expectedOutput = "    111    \n" + "    222    \n" + "    333    \n" + "  4444444  \n";
	assertEquals(expectedOutput, text.toString());
}

@Test
public void test10() {
	FormattedText text = new CenteredText(11);
	assertEquals(false, text.add(""));
}
```

## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes **unless asked to**.
+ You can use additional standard Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.

## Answers to FAQs

#### Can I consult Java documentation and other Internet-based sources?

Yes, you can. The point of this test is not to demonstrate mastery over syntax but that you can solve a problem in a reasonable amount of time with reasonable resources.

*If you find useful information online outside the official Java documentation and the course material, you must cite the source. You should do so by adding comments in your source code.*

Naturally you are expected to adhere to all of the course and UBC policies on academic integrity.

#### Isn't one hour too short to produce a working implementation?

The questions are straightforward, and these are not very different from what one might sometimes encounter on a job interview (for example). The difference is that you get less time during an interview (10-15 minutes) with no access to additional resources. So the time allotted is reasonable in that regard and I am expecting that everyone will be able to clear this bar. The goal is that it is possible to say, at a minimal level, what everyone who completes this course can achieve.

#### Why am I not guaranteed full credit if my implementation passes all the provided tests?

It is easy to develop an implementation that passes the provided tests and not much else. A good-faith implementation that passes all the provided tests is very likely to pass other tests too.
