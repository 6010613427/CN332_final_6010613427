package com.javaskool;

import java.util.Scanner;
import com.javaskool.facade.HotelFacade;
import com.javaskool.model.RoomType;

public class TestDrive {
	public static void main(String arg[]){
		
		HotelFacade facade=new HotelFacade();
		facade.displayAvailableRooms();
		
		//Automatically from facade
		//System.out.println(facade.reserve(RoomType.DOUBLE));

		//For Customer Choice
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Room No :");
		int i=sc.nextInt();
		System.out.println(facade.reserve(RoomType.SINGLE,i));
		
		//System.out.println(facade.reserve(RoomType.DOUBLE));
		//System.out.println(facade.reserve(RoomType.SINGLE));		
		facade.displayAvailableRooms();		
	}
}
