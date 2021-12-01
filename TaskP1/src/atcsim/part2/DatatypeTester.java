package atcsim.part2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import atcsim.datatype.*;

//API https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html

class DatatypeTester {

	@Test
	public void testAltitude() {
		
		Altitude testAlt = new Altitude(1000);
		Altitude testAlt2 = new Altitude(200);
		
		//assertEquals(Expected Result(We set this),Actual Result(The result that is calculated))
		
		//alt + alt2
		Altitude add = testAlt.add_(testAlt2);
		double addResult = add.getValue_();
		assertEquals(1200, addResult,"from result");
		
		//alt2 + alt
		Altitude add2 = testAlt2.add_(testAlt);
		double addResult2 = add2.getValue_();
		assertEquals(1200, addResult2,"from result");
		
		//alt - alt2
		Altitude sub = testAlt.subtract_(testAlt2);
		double subResult = sub.getValue_();
		assertEquals(800, subResult);
		
		//alt2 - alt
		Altitude sub2 = testAlt2.subtract_(testAlt);
		double subResult2 = sub2.getValue_();
		assertEquals(-800, subResult2);
		
		//alt = alt or 1000 == 1000
		int res = testAlt.compareTo(testAlt);
		assertEquals(0,res);
		
		// alt < alt2  or 1000 < 200
		//   returns 1
		//needs a check
		int res2 = testAlt.compareTo(testAlt2);
		assertEquals(1,res2);
		
		// alt2 > alt or 200 > 1000
		//returns -1
		//needs a check
		int res3 = testAlt2.compareTo(testAlt);
		assertEquals(-1,res3);
		
		
	}
	
	@Test
	public void testAngleNavigational() {
		AngleNavigational testAngleNav1 = new AngleNavigational(90);
		AngleNavigational testAngleNav2 = new AngleNavigational(180);
		
		//assertEquals(Expected Result(We set this),Actual Result(The result that is calculated))
		
		//testAngleNav1 reciprocal
		AngleNavigational recipResult1 = testAngleNav1.reciprocate();
		assertEquals(270.0, recipResult1.getValue_(),"from result");
		
		//testAngleNav2 reciprocal
		AngleNavigational recipResult2 = testAngleNav2.reciprocate();
		assertEquals(0.0, recipResult2.getValue_(),"from result");
		
		
		//testAngleNav1 interpolate
		AngleNavigational interpResult1 = testAngleNav1.interpolate(testAngleNav2,Scaler.HALF);
		assertEquals(135, interpResult1.getValue_(),"from result");
		
		//testAngleNav2 interpolate
		AngleNavigational interpResult2 = testAngleNav2.interpolate(testAngleNav1,Scaler.HALF);
		assertEquals(315, interpResult2.getValue_(),"from result");
		
	}
	
	@Test
	public void testAttitudePitch() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAttitudeYaw() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCourse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCoordinateWorld() {
		CoordinateWorld testP1 = CoordinateWorld.KSFF;
		CoordinateWorld testP2 = new CoordinateWorld(new Latitude(1,2,3),new Longitude(3,2,1));
		
		//assertEquals(Expected Result(We set this),Actual Result(The result that is calculated))
		
		//test P1 is P1
		int comparison = testP1.compareTo(testP1);
		assertEquals(0, comparison,"from result");
		
		//test P1 + P2
		CoordinateWorld sum = testP1.add_(testP1);
		assertEquals(0, sum.getValue_(),"from result");
	}
	
	@Test
	public void testCoordinateWorld3D() {
		fail("Not yet implemented");
	}
	
	

		
	
	

}
