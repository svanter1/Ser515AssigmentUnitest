/**
 * "Dark Triangles" demonstrates black box testing for educational purposes.
 * Copyright (C) 2010-2013 Daniel Speicher and University of Bonn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package geometry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import geometry.basic.Point;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
//import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TriangleTest {

	/*
	 * The following methods make sure that the test is run for all Triangle
	 * classes we are interested in. You don't need to understand the mechanics, 
	 * just make sure that you never create a triangle directly, but use one of 
	 * the methods createTriangle(...).
	 */
	private Class<Triangle> classUnderTest;

	@SuppressWarnings("unchecked")
	public TriangleTest(Object classUnderTest) {
		this.classUnderTest = (Class<Triangle>) classUnderTest;
	}

	@Parameters
	public static Collection<Object[]> triangleClassesUnderTest() {
		Object[][] classes = { 
				{ Triangle00.class },
				{ Triangle01.class },
				{ Triangle02.class },
				{ Triangle03.class }, 
				{ Triangle04.class },
				{ Triangle05.class },
				{ Triangle06.class },
				{ Triangle07.class },
				{ Triangle08.class },
				{ Triangle09.class },
				{ Triangle10.class },
				{ Triangle11.class },	
				{ Triangle12.class },
				{ Triangle13.class },
				{ Triangle14.class },
				{ Triangle15.class } ,
				{ Triangle16.class }
		};
		return Arrays.asList(classes);
	}

	private Triangle createTriangle(Point a, Point b, Point c) throws Exception {
		Constructor<Triangle> constructor = classUnderTest.getConstructor(
				Point.class, Point.class, Point.class);
		return constructor.newInstance(a, b, c);
	}

	private Triangle createTriangle(double ax, double ay, double bx, double by,
			double cx, double cy) throws Exception {
		Point a = new Point(ax, ay);
		Point b = new Point(bx, by);
		Point c = new Point(cx, cy);
		return createTriangle(a, b, c);
	}

	/*
	 * Create some triangles for the test.
	 * 
	 * Remember to always use createTriangle(...) to create a triangle. Never
	 * call the constructor directly. This allows us to run the test for all the
	 * classes one after another.
	 */
	private Triangle triangle;
	private Triangle equalToTriangle;
	private Triangle veryLargeTriangle;
	private Triangle verySmallTriangle;
	private Triangle rightTriangle;
	private Triangle BigRightTriangle;
	private Triangle equiTriangle;
	private Triangle BigequiTriangle;
	private Triangle equaltriangle1;
	private Triangle IsoscelesTriangle;
	private Triangle ScaleneTriangle;
	private Triangle SamebaseTriangle1;
	private Triangle SamebaseTriangle2;
/* in the following code we are creating traingles such as big right angled triangle, small right angled triangle , equilateral, bigequivalertal,equaltraingle etc*/
	@Before
	public void setUpBefore() throws Exception {
		Point a = new Point(1.2, 2.3);
		Point b = new Point(4.3, 5.1);
		Point c = new Point(3.1, 10.0);
		triangle = createTriangle(a, b, c); 
		equalToTriangle = createTriangle(c, b, a);
		veryLargeTriangle = createTriangle(-10000.0, -10000.0, +10000.0,
				-10000.0, 0.0, +20000.0);
		verySmallTriangle = createTriangle(-0.00001, -0.00001, +0.00001,
				-0.00001, 0.0, +0.00002);
		rightTriangle = createTriangle(0,0,0,3,4,0);
		BigRightTriangle = createTriangle(0,0,0,12,16,0);
		equiTriangle = createTriangle(0,0,6,0,3,Math.sqrt(27)); 
		BigequiTriangle = createTriangle(-4,-2,16,-2,6,Math.sqrt(300)-2);
		equaltriangle1 = createTriangle(0,0,0,3,4,0);
		IsoscelesTriangle = createTriangle(0,0,0,6,6,0);
		ScaleneTriangle= createTriangle(-3,0,3,0,1,2);
		SamebaseTriangle1= createTriangle(0,0,8,0,10,4);
		SamebaseTriangle2= createTriangle(0,0,8,0,2,4);
		
	}
/*  in this test case we are checking that whether the triangle contains itself or not*/
	@Test
	public void ifATriangleIsComparedWithItself() throws Exception {
		assertTrue("... it should contain itself.", triangle.contains(triangle));
		assertTrue(" it should contain itself.", rightTriangle.contains(rightTriangle));
		assertTrue(" it should contain itself.", BigRightTriangle.contains(BigRightTriangle));
		assertTrue(" it should contain itself.", equiTriangle.contains(equiTriangle));
		assertTrue(" it should contain itself.", BigequiTriangle.contains(BigequiTriangle));
		assertTrue(" it should contain itself.", equaltriangle1.contains(equaltriangle1));
		assertTrue(" it should contain itself.", ScaleneTriangle.contains(ScaleneTriangle));
		
	}
	@Test
	/* in this testcase we are testing that the triangles which are not to be contained as they are completely different and different cordinates too*/
	public void DifferentTriangleshouldnotcontaineachother() throws Exception {
		assertFalse("should not contain.",rightTriangle.equals(equiTriangle));//right triangle and equilateral has different cordiantes and should not contain each other
		assertFalse("should not contain.",equiTriangle.equals(rightTriangle));// right triangle and equilateral has different cordiantes and should not contain each other
		assertFalse("should not contain.",ScaleneTriangle.equals(rightTriangle));//similarly here
	}
/*equal traingles contain each other but should be different,*/
	@Test
	public void ifTrianglesAreEqualToEachOther() throws Exception {
		assertTrue("... they should contain each other.",
				triangle.contains(equalToTriangle));
		assertTrue("The triangles should actually be equal.",
				triangle.equals(equalToTriangle));
		assertFalse("But not the same.", triangle == equalToTriangle);
		assertTrue("... they should contain each other.",
				rightTriangle.contains(equaltriangle1));
		assertTrue("The triangles should actually be equal.",
				rightTriangle.equals(equaltriangle1));
		assertFalse("But not the same.", rightTriangle == equaltriangle1); 
	}

	@Test
	public void ifATriangleIsJustACornerOfAnotherTriangle() throws Exception {
		Point x = new Point(Math.E, Math.E); // Some strange values for this 
											 // simple case.
		Point y = new Point(Math.PI, Math.E);
		Point z = new Point(Math.PI, Math.PI);
		Triangle fullTriangle = createTriangle(x, y, z);
		Triangle pointX = createTriangle(x, x, x);
		Triangle pointY = createTriangle(y, y, y);
		Triangle pointZ = createTriangle(z, z, z);
		assertTrue("... it is part of the triangle",
				fullTriangle.contains(pointX));
		assertTrue("... it is part of the triangle",
				fullTriangle.contains(pointY));
		assertTrue("... it is part of the triangle",
				fullTriangle.contains(pointZ));
				
	   
	 
	}
	@Test
	public void BigRightTriangleContainsSmallone() throws Exception {
		assertTrue("Small right angled Triangle is part of big right angled Triangle",
				BigRightTriangle.contains(rightTriangle));
		assertFalse("Big right angled Triangle is not part of small right angled Triangle",
				rightTriangle.contains(BigRightTriangle));
						
	    assertTrue(" Small equilateral Triangle is a part of right angled ",
				BigRightTriangle.contains(equiTriangle));
		assertFalse("Big right angled Triangle is not part of equilateral angled Triangle",
				equiTriangle.contains(BigRightTriangle));
				assertTrue("Small right angled Triangle is part of big right angled  isosceles Triangle",
				IsoscelesTriangle.contains(rightTriangle));
				assertFalse("isosceles right angled Triangle is part of small right angled  isosceles Triangle",
				rightTriangle.contains(IsoscelesTriangle));
				assertTrue("Small right angled Triangle is part of big right angled  isosceles Triangle",
						BigRightTriangle.contains(IsoscelesTriangle));
						assertFalse("isosceles right angled Triangle is part of small right angled  isosceles Triangle",
								IsoscelesTriangle.contains(BigRightTriangle));
						
	}
	@Test
	public void BigEquilateralTriangleContainsSmallone() throws Exception {
	assertTrue("... the large one should contain the small one.",
				BigequiTriangle.contains(equiTriangle)); 
		assertFalse("... the small one should not contain the large one.",
				equiTriangle.contains(BigequiTriangle)); }
	 
	@Test
	public void Samebasetraingleshouldnotcontain() throws Exception {
		assertFalse("same base should not contain each other",SamebaseTriangle1.contains(SamebaseTriangle2));
		
	}
	
	
	@Test
	public void ifOneTriangleIsVeryLargeAndTheOtherVerySmall() throws Exception {
		assertTrue("... the large one should contain the small one.",
				veryLargeTriangle.contains(verySmallTriangle));
		assertFalse("... the small one should not contain the large one.",
		verySmallTriangle.contains(veryLargeTriangle));	
		assertTrue("... the large one should contain the small one.",
				veryLargeTriangle.contains(BigequiTriangle));
		assertFalse("... the large one should contain the small one.",
				BigequiTriangle.contains(veryLargeTriangle));
	}
	}
	

 	