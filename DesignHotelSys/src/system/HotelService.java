
import com.javacodegeeks.patterns.adapterpattern.payd.PayD;
import com.javacodegeeks.patterns.adapterpattern.site.XpayImpl;
import com.javacodegeeks.patterns.adapterpattern.site.XpayToPayDAdapter;
import com.javacodegeeks.patterns.adapterpattern.xpay.Xpay;
import com.javaskool.facade.HotelFacade;
import com.javaskool.model.RoomType;
import java.util.Scanner;
import system.Hotel;
import system.Login;
import system.ProxyInternet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class HotelService {

    public static void main(String[] args) {

       
        System.out.println("Welcome to Hotel-Service");
        
        Login login = new ProxyInternet();
        try
        {
            login.connectTo("You can connect via facebook.com");
            login.connectTo("You can connect via gmail.com");
            login.connectTo("You can connect via hotmail.com");
            login.connectTo("fake.com");
            
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        
        //HotelBooking bookhotel = new HotelBooking();
        Hotel eachhotel = new Hotel();

        //HotelTarget hotelAdapter = new HotelAdapter(eachhotel);
//		System.out.println("The Hotel");
       Scanner customername = new Scanner(System.in);   
       System.out.print("Please fill in your name: ");
              String name = customername.nextLine();
       System.out.print("Enter Checkin day [DD/MM/YYYY]: ");
        Scanner checkinday = new Scanner(System.in);
       String checkin = checkinday.nextLine();

        eachhotel.bookName(name);
        eachhotel.roomleft();
        eachhotel.checkin(checkin);
        

        
        System.out.println();
        HotelFacade facade=new HotelFacade();
		facade.displayAvailableRooms();
		
		//Automatically from facade
		//System.out.println(facade.reserve(RoomType.DOUBLE));

		//For Customer Choice
		Scanner room=new Scanner(System.in);
		System.out.print("Enter Room No :");
		int numroom=room.nextInt();
		System.out.println(facade.reserve(RoomType.SINGLE,numroom));
		
		//System.out.println(facade.reserve(RoomType.DOUBLE));
		//System.out.println(facade.reserve(RoomType.SINGLE));		
		facade.displayAvailableRooms();	
                	// Object for Xpay
		Xpay xpay = new XpayImpl();
		xpay.setCreditCardNo("4789565874102365");
		xpay.setCustomerName("Chun dilmurat");
		xpay.setCardCVVNo((short)235);
		xpay.setAmount(2565.23);
		
		PayD payD = new XpayToPayDAdapter(xpay);
		testPayD(payD);
	}
	
	private static void testPayD(PayD payD){
		
		System.out.println(payD.getCardOwnerName());
		System.out.println(payD.getCustCardNo());
		System.out.println(payD.getCardExpMonthDate());
		System.out.println(payD.getCVVNo());
		System.out.println(payD.getTotalAmount());
	}

    }

