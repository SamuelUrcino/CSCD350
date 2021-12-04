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
		assertEquals(1200, addResult,.01);
		
		//alt2 + alt
		Altitude add2 = testAlt2.add_(testAlt);
		double addResult2 = add2.getValue_();
		assertEquals(1200, addResult2,.01);
		
		//alt - alt2
		Altitude sub = testAlt.subtract_(testAlt2);
		double subResult = sub.getValue_();
		assertEquals(800, subResult,.01);
		
		//alt2 - alt
		Altitude sub2 = testAlt2.subtract_(testAlt);
		double subResult2 = sub2.getValue_();
		assertEquals(-800, subResult2,.01);
		
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
	
	//done by Savannah
	@Test
	public void testAttitudePitch() {
		//fail("Not yet implemented");
		 // Create pitch (p = 10)
        AttitudePitch p = new AttitudePitch(10); 

        // Verify (0 + p) is correct
        AttitudePitch zero = new AttitudePitch(0);
        AttitudePitch sum1 = p.add_(zero); 
        double sum1Result = sum1.getValue_();
        assertEquals(10, sum1Result,.01);

        // Verify (90 + p) is correct
        AttitudePitch ninety = new AttitudePitch(90);
        AttitudePitch sum2 = p.add_(ninety); 
        double sum2Result = sum2.getValue_();
        assertEquals(100, sum2Result,.01);


        // Verify (175 + p) is correct
        AttitudePitch oneSeventyFive = new AttitudePitch(175);
        AttitudePitch sum3 = p.add_(oneSeventyFive); 
        double sum3Result = sum3.getValue_();
        assertEquals(-175, sum3Result,.01);
	}
	
	@Test
	public void testAttitudeYaw() {
		AttitudeYaw testYaw  = new AttitudeYaw(10);
		
		//-5 + testYaw
		AttitudeYaw yaw = new AttitudeYaw(-5);
		AttitudeYaw yawResult = yaw.add_(testYaw);
		assertEquals(5.0,yawResult.getValue_(),.01);
		 
		//175 + testYaw
		AttitudeYaw yaw2 = new AttitudeYaw(175);
		AttitudeYaw yaw2Result = yaw2.add_(testYaw);
		assertEquals(-175.0,yaw2Result.getValue_(),.01);
		
		//5 - testYaw or 5 - 10
		AttitudeYaw yaw3 = new AttitudeYaw(5);
		AttitudeYaw yaw3Result = yaw3.subtract_(testYaw);
		assertEquals(-5,yaw3Result.getValue_(),.01);
		
		//-175 - testYaw or -175 - 10
		AttitudeYaw yaw4 = new AttitudeYaw(-175);
		AttitudeYaw yaw4Result = yaw4.subtract_(testYaw);
		assertEquals(175,yaw4Result.getValue_(),.01);
		
	}
	
	//done by Savannah
	@Test
	public void testCourse() {
		// fail("Not yet implemented");

        // Create course (c = 10)
        Course c = new Course(10);

        // Verify (0 + c) is correct
        Course zero = new Course(0);
        Course sum1 = c.add_(zero); 
        double sum1Result = sum1.getValue_();
        assertEquals(10, sum1Result,.01);

        // Verify (355 + c) is correct
        Course threeFiftyFive = new Course(355);
        Course sum2 = c.add_(threeFiftyFive); 
        double sum2Result = sum2.getValue_();
        assertEquals(5, sum2Result,.01);

        // Verify (0 - c) is correct
        Course difference1 = zero.subtract_(c); 
        double difference1Result = difference1.getValue_();
        assertEquals(350, difference1Result,.01);

        // Verify (355 - c) is correct
        Course difference2 = threeFiftyFive.subtract_(c); 
        double difference2Result = difference2.getValue_();
        assertEquals(345, difference2Result,.01);
	}

	
	@Test
	public void testCoordinateWorld() {
		CoordinateWorld testP1 = CoordinateWorld.KSFF;
		CoordinateWorld testP2 = new CoordinateWorld(new Latitude(1,2,3),new Longitude(3,2,1));
		
		//assertEquals(Expected Result(We set this),Actual Result(The result that is calculated))
		
		//test P1 is P1
		//int comparison = testP1.compareTo(testP1);
		assertEquals(0, testP1.getLatitude().compareTo(CoordinateWorld.KSFF.getLatitude()),"comparing Latitude");
		assertEquals(0, testP1.getLongitude().compareTo(CoordinateWorld.KSFF.getLongitude()),"comparing Longitude");
		
		//test P1 + P2
		CoordinateWorld sum = testP1.add_(testP2);
		CoordinateWorld shouldbe = new CoordinateWorld(CoordinateWorld.KSFF.getLatitude().add_(new Latitude(1,2,3)),CoordinateWorld.KSFF.getLongitude().add_(new Longitude(3,2,1)));
		//assertEquals(0, sum.compareTo(shouldbe),"from result");
		assertEquals(0, sum.getLatitude().compareTo(shouldbe.getLatitude()),"comparing Latitude");
		assertEquals(0, sum.getLongitude().compareTo(shouldbe.getLongitude()),"comparing Longitude");
	}
	
	@Test
	public void testCoordinateWorld3D() {
		
		CoordinateWorld3D p = CoordinateWorld3D.KSFF;
		CoordinatePolarNavigational3D pbearing = p.calculateBearing3D(p);
		assertEquals(90,pbearing.getAngle().getValue_(),"angle of bearing to itself");
		assertEquals(0,pbearing.getRadiusNauticalMiles().getValue_(),"distance of p to itself");
		
		CoordinateWorld eastpoint = p.getCoordinateWorld().KSFF_E; //p.calculateBearing3D(new CoordinateCoordinateWorld.KSFF_E);
		CoordinatePolarNavigational3D eastbearing = p.calculateBearing3D(new CoordinateWorld3D(eastpoint,p.getAltitude()));
		assertEquals(90,eastbearing.getAngle().getValue_(),"angle of bearing to east");
		assertEquals(794.038,eastbearing.getRadiusNauticalMiles().getValue_(),0.1,"distance of p to 10 minutes east");
		
		CoordinateWorld southpoint = p.getCoordinateWorld().KSFF_S; //p.calculateBearing3D(new CoordinateCoordinateWorld.KSFF_E);
		CoordinatePolarNavigational3D southbearing = p.calculateBearing3D(new CoordinateWorld3D(southpoint,p.getAltitude()));
		assertEquals(180,southbearing.getAngle().getValue_(),"angle of bearing to south");
		assertEquals(794.038,southbearing.getRadiusNauticalMiles().getValue_(),0.1,"distance of p to 10 minutes south");
		
		CoordinateWorld westpoint = p.getCoordinateWorld().KSFF_W; //p.calculateBearing3D(new CoordinateCoordinateWorld.KSFF_E);
		CoordinatePolarNavigational3D westbearing = p.calculateBearing3D(new CoordinateWorld3D(westpoint,p.getAltitude()));
		assertEquals(270,westbearing.getAngle().getValue_(),"angle of bearing to west");
		assertEquals(794.038,westbearing.getRadiusNauticalMiles().getValue_(),0.1,"distance of p to 10 minutes west");
		
		CoordinateWorld northpoint = p.getCoordinateWorld().KSFF_N; //p.calculateBearing3D(new CoordinateCoordinateWorld.KSFF_E);
		CoordinatePolarNavigational3D northbearing = p.calculateBearing3D(new CoordinateWorld3D(northpoint,p.getAltitude()));
		assertEquals(0,northbearing.getAngle().getValue_(),"angle of bearing to north");
		assertEquals(794.038,northbearing.getRadiusNauticalMiles().getValue_(),0.1,"distance of p to 10 minutes north");
		
	}
	
	

		
	
	

}
