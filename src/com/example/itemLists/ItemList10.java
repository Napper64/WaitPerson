package com.example.itemLists;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import com.example.orders.Order10;
import com.example.waitperson.R;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class ItemList10 extends ActionBarActivity{
	
	private String message10;
	private int requestCode;
	private static final String PREFERENCES = null;
	private final int MENU_VIEW_ORDER=1, MENU_DELETE_ORDER=2;
    private final int GROUP_DEFAULT=0, GROUP_DEL=1;
    private static int order10=0;
	private Intent i;
	private int smallBurgerValue;
	private int regularBurgerValue;
	private int largeBurgerValue;
	private int extraLargeBurgerValue;
	private double smallBurgerPrice;
	private double regularBurgerPrice;
	private double largeBurgerPrice;
	private double extraLargeBurgerPrice;
	private int smallChickenBurgerValue;
	private int regularChickenBurgerValue;
	private int largeChickenBurgerValue;
	private int extraLargeChickenBurgerValue;
	private double smallChickenBurgerPrice;
	private double regularChickenBurgerPrice;
	private double largeChickenBurgerPrice;
	private double extraLargeChickenBurgerPrice;
	private int smallCokeValue;
	private int regularCokeValue;
	private int largeCokeValue;
	private int extraLargeCokeValue;
	private double smallCokePrice;
	private double regularCokePrice;
	private double largeCokePrice;
	private double extraLargeCokePrice;
	private int smallFantaValue;
	private int regularFantaValue;
	private int largeFantaValue;
	private int extraLargeFantaValue;
	private double smallFantaPrice;
	private double regularFantaPrice;
	private double largeFantaPrice;
	private double extraLargeFantaPrice;
	private int smallFishValue;
	private int regularFishValue;
	private int largeFishValue;
	private int extraLargeFishValue;
	private double smallFishPrice;
	private double regularFishPrice;
	private double largeFishPrice;
	private double extraLargeFishPrice;
	private int smallFriesValue;
	private int regularFriesValue;
	private int largeFriesValue;
	private int extraLargeFriesValue;
	private double smallFriesPrice;
	private double regularFriesPrice;
	private double largeFriesPrice;
	private double extraLargeFriesPrice;
	private int smallPizzaValue;
	private int regularPizzaValue;
	private int largePizzaValue;
	private int extraLargePizzaValue;
	private double smallPizzaPrice;
	private double regularPizzaPrice;
	private double largePizzaPrice;
	private double extraLargePizzaPrice;
	private int smallWaterValue;
	private int regularWaterValue;
	private int largeWaterValue;
	private int extraLargeWaterValue;
	private double smallWaterPrice;
	private double regularWaterPrice;
	private double largeWaterPrice;
	private double extraLargeWaterPrice;
	private ImageButton button;
	final CharSequence[] items = {"Small", "Regular", "Large", "Extra Large"};
	private int item;
	

/**
 * Mobile Applications Development Assignment 2 
 * @author Niall McCarthy
 * @ID R00020593
 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_list);

		// Restore Intent
		restoreIntent();

		// Restore Item Quantities and Prices
		restoreValueVariables();
		restorePriceVariables();

		// Setup Image Buttons
		BeefBurgerClick();
		ChickenBurgerClick();
		CokeClick();
		FantaClick();
		FishClick();
		FriesClick();
		PizzaClick();
		WaterClick();

	}

	// Method used to save current Intent state
	public void saveIntent(Intent intent) {
		SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
		SharedPreferences.Editor editor = settings.edit();

		String uriString = intent.toUri(requestCode);
		editor.putString("Saved_Intent10", uriString);
		editor.commit();
	}

	// Method used to restore Intent state
	private void restoreIntent() {
		SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
		String Saved_Intent = settings.getString("Saved_Intent10", null);
		try {
			i = Intent.parseUri(Saved_Intent, 0);
		} catch (Exception e) {
			//If there is no Intent State saved, create a new one
			i = new Intent(this, Order10.class);
			return;
		}
	}



	// Method used to create Menu Options
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 	menu.add(GROUP_DEFAULT, MENU_VIEW_ORDER, 0, "View Order").setIcon(R.drawable.order); 
	        menu.add(GROUP_DEL, MENU_DELETE_ORDER, 0, "Delete Order");

	        return super.onCreateOptionsMenu(menu);
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 switch(item.getItemId()) {
		// View the table's Food Order
	        case MENU_VIEW_ORDER:
	            view_order();
	            return true;
	         // Delete the table's Order
	        case MENU_DELETE_ORDER:
	            delete_order();
	            return true;
	        }
		return super.onOptionsItemSelected(item);
	}
	

	@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(order10==1) { 
            menu.setGroupVisible(GROUP_DEL, true);
        } else {
            menu.setGroupVisible(GROUP_DEL, false);            
        }
        return super.onPrepareOptionsMenu(menu);
    }

	
	private void view_order() {
		startActivity(i);
		
	}

	// Method to Delete Order
	private void delete_order() {
		 Bundle extras = i.getExtras();
		    if (extras != null) {
		        Set<String> keys = extras.keySet();
		        Iterator<String> it = keys.iterator();
		        while (it.hasNext()) {
		            String key = it.next();
		            i.removeExtra(key);
		        }
		        // Reset all the Variables back to null
		        resetValueVariables();
		        resetPriceVariables();
		        
		        // Save the new Intent State
		        saveIntent(i);
		    }
		}
	
	

	/**
	 * The Following Methods detail all the image button
	 * options and their menus
	 */

	// Beef Burger Image Button 
	public void BeefBurgerClick() {
		 button = (ImageButton) findViewById(R.id.imagebutton0);
		 button.setOnClickListener(new OnClickListener() {
                 @Override
                 public void onClick(View arg0) {
                
                	 AlertDialog.Builder builder = new AlertDialog.Builder(ItemList10.this);
                	 builder.setTitle(" ");
                	 builder.setIcon(R.drawable.beefburger);
                	 builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                	     public void onClick(DialogInterface dialog, int itemId) {
                	    	item=itemId;
                	  Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                	     }
                	 });

                	 builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                	   public void onClick(DialogInterface dialog, int id) {
                		   order10=1;
                		   String order10String=Integer.toString(order10);
                		   save("order10", order10String);
                		   if(item==0){
                	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                	   smallBurgerValue++;
                	   smallBurgerPrice=smallBurgerPrice +  2.30 ;
                	   String smallBurgerValueString=Integer.toString(smallBurgerValue);
                	   String smallBurgerPriceString=Double.toString(smallBurgerPrice);
        				i.putExtra("smallBurgerValue", "Small Beef Burger x " + smallBurgerValueString );
        				save("smallBurgerValue10", smallBurgerValueString);
        				save("smallBurgerPrice10", smallBurgerPriceString);
                		   }
                		   else if(item==1){
                       	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                       	regularBurgerValue++;
                       	regularBurgerPrice=regularBurgerPrice + 3.30;
                       	 String regularBurgerValueString=Integer.toString(regularBurgerValue);
                       	String  regularBurgerPriceString=Double.toString( regularBurgerPrice);
         				i.putExtra("regularBurgerValue", "Regular Beef Burger x " + regularBurgerValueString );
         				save("regularBurgerValue10", regularBurgerValueString);
         				save("smallBurgerPrice10", regularBurgerPriceString);
         				
                       		   }
                		   else if(item==2){
                          	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                          	  largeBurgerValue++;
                          	largeBurgerPrice=largeBurgerPrice + 4.30;
                          	String largeBurgerValueString=Integer.toString(largeBurgerValue);
                          	String  largeBurgerPriceString=Double.toString( largeBurgerPrice);
               				i.putExtra("largeBurgerValue", "Large Beef Burger x " + largeBurgerValueString );
               				save("largeBurgerValue10", largeBurgerValueString);
               				save("largeBurgerPrice10", largeBurgerPriceString);
                          		   }
                		   else if(item==3){
                          	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                          	  extraLargeBurgerValue++;
                          	extraLargeBurgerPrice=extraLargeBurgerPrice+5.45;
                          	String  extraLargeBurgerValueString=Integer.toString(extraLargeBurgerValue);
                          	String  extraLargeBurgerPriceString=Double.toString( extraLargeBurgerPrice);
               				i.putExtra("extraLargeBurgerValue","Extra Large Beef Burger x " + extraLargeBurgerValueString );
               				save("extraLargeBurgerValue10", extraLargeBurgerValueString);
               				save("extraLargeBurgerPrice10", extraLargeBurgerPriceString);
                          		   }
                		   saveIntent(i);
                		   
                	   }
                	  });
                	 builder.setNegativeButton("No",
                	  new DialogInterface.OnClickListener() {
                	   public void onClick(DialogInterface dialog, int id) {
                	   }
                	  });
                	 AlertDialog alert = builder.create();
                	 alert.show();
                 }
         });
 }
	
	// Chicken Burger Image Button 
	public void ChickenBurgerClick() {
		 button = (ImageButton) findViewById(R.id.imagebutton1);
		 button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View arg0) {
               	 
               	 AlertDialog.Builder builder = new AlertDialog.Builder(ItemList10.this);
               	 builder.setTitle(" ");
               	 builder.setIcon(R.drawable.chickenburger);
               	 builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
               	     public void onClick(DialogInterface dialog, int itemId) {
               	    	item=itemId;
               	  Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
               	     }
               	 });

               	 builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
               	   public void onClick(DialogInterface dialog, int id) {
               		   order10=1;
               		   String order10String=Integer.toString(order10);
               		   save("order10", order10String);
               		   if(item==0){
               	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
               	   smallChickenBurgerValue++;
               	   smallChickenBurgerPrice=smallChickenBurgerPrice +  2.30 ;
               	   String smallChickenBurgerValueString=Integer.toString(smallChickenBurgerValue);
               	   String smallChickenBurgerPriceString=Double.toString(smallChickenBurgerPrice);
       				i.putExtra("smallChickenBurgerValue", "Small Chicken Burger x " + smallChickenBurgerValueString );
       				save("smallChickenBurgerValue10", smallChickenBurgerValueString);
       				save("smallChickenBurgerPrice10", smallChickenBurgerPriceString);
               		   }
               		   else if(item==1){
                      	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                      	regularChickenBurgerValue++;
                      	regularChickenBurgerPrice=regularChickenBurgerPrice + 3.30;
                      	 String regularChickenBurgerValueString=Integer.toString(regularChickenBurgerValue);
                      	String  regularChickenBurgerPriceString=Double.toString( regularChickenBurgerPrice);
        				i.putExtra("regularChickenBurgerValue", "Regular Chicken Burger x " + regularChickenBurgerValueString );
        				save("regularChickenBurgerValue10", regularChickenBurgerValueString);
        				save("smallChickenBurgerPrice10", regularChickenBurgerPriceString);
        				
                      		   }
               		   else if(item==2){
                         	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                         	  largeChickenBurgerValue++;
                         	largeChickenBurgerPrice=largeChickenBurgerPrice + 4.30;
                         	String largeChickenBurgerValueString=Integer.toString(largeChickenBurgerValue);
                         	String  largeChickenBurgerPriceString=Double.toString( largeChickenBurgerPrice);
              				i.putExtra("largeChickenBurgerValue", "Large Chicken Burger x " + largeChickenBurgerValueString );
              				save("largeChickenBurgerValue10", largeChickenBurgerValueString);
              				save("largeChickenBurgerPrice10", largeChickenBurgerPriceString);
                         		   }
               		   else if(item==3){
                         	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                         	  extraLargeChickenBurgerValue++;
                         	extraLargeChickenBurgerPrice=extraLargeChickenBurgerPrice+5.45;
                         	String  extraLargeChickenBurgerValueString=Integer.toString(extraLargeChickenBurgerValue);
                         	String  extraLargeChickenBurgerPriceString=Double.toString( extraLargeChickenBurgerPrice);
              				i.putExtra("extraLargeChickenBurgerValue","Extra Large Chicken Burger x " + extraLargeChickenBurgerValueString );
              				save("extraLargeChickenBurgerValue10", extraLargeChickenBurgerValueString);
              				save("extraLargeChickenBurgerPrice10", extraLargeChickenBurgerPriceString);
                         		   }
               		   saveIntent(i);
               		   
               	   }
               	  });
               	 builder.setNegativeButton("No",
               	  new DialogInterface.OnClickListener() {
               	   public void onClick(DialogInterface dialog, int id) {
               	   }
               	  });
               	 AlertDialog alert = builder.create();
               	 alert.show();
                }
        });
}
	
	// Coke Image Button 
	public void CokeClick() {
		 button = (ImageButton) findViewById(R.id.imagebutton2);
		 button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View arg0) {
               	 
               	 AlertDialog.Builder builder = new AlertDialog.Builder(ItemList10.this);
               	 builder.setTitle(" ");
               	 builder.setIcon(R.drawable.coke);
               	 builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
               	     public void onClick(DialogInterface dialog, int itemId) {
               	    	item=itemId;
               	  Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
               	     }
               	 });

               	 builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
               	   public void onClick(DialogInterface dialog, int id) {
               		   order10=1;
               		   String order10String=Integer.toString(order10);
               		   save("order10", order10String);
               		   if(item==0){
               	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
               	   smallCokeValue++;
               	   smallCokePrice=smallCokePrice +  1.30 ;
               	   String smallCokeValueString=Integer.toString(smallCokeValue);
               	   String smallCokePriceString=Double.toString(smallCokePrice);
       				i.putExtra("smallCokeValue", "Small Coke x " + smallCokeValueString );
       				save("smallCokeValue10", smallCokeValueString);
       				save("smallCokePrice10", smallCokePriceString);
               		   }
               		   else if(item==1){
                      	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                      	regularCokeValue++;
                      	regularCokePrice=regularCokePrice + 2.30;
                      	 String regularCokeValueString=Integer.toString(regularCokeValue);
                      	String  regularCokePriceString=Double.toString( regularCokePrice);
        				i.putExtra("regularCokeValue", "Regular Coke x " + regularCokeValueString );
        				save("regularCokeValue10", regularCokeValueString);
        				save("smallCokePrice10", regularCokePriceString);
        				
                      		   }
               		   else if(item==2){
                         	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                         	  largeCokeValue++;
                         	largeCokePrice=largeCokePrice + 3.30;
                         	String largeCokeValueString=Integer.toString(largeCokeValue);
                         	String  largeCokePriceString=Double.toString( largeCokePrice);
              				i.putExtra("largeCokeValue", "Large Coke x " + largeCokeValueString );
              				save("largeCokeValue10", largeCokeValueString);
              				save("largeCokePrice10", largeCokePriceString);
                         		   }
               		   else if(item==3){
                         	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                         	  extraLargeCokeValue++;
                         	extraLargeCokePrice=extraLargeCokePrice+3.99;
                         	String  extraLargeCokeValueString=Integer.toString(extraLargeCokeValue);
                         	String  extraLargeCokePriceString=Double.toString( extraLargeCokePrice);
              				i.putExtra("extraLargeCokeValue","Extra Large Coke x " + extraLargeCokeValueString );
              				save("extraLargeCokeValue10", extraLargeCokeValueString);
              				save("extraLargeCokePrice10", extraLargeCokePriceString);
                         		   }
               		   saveIntent(i);
               		   
               	   }
               	  });
               	 builder.setNegativeButton("No",
               	  new DialogInterface.OnClickListener() {
               	   public void onClick(DialogInterface dialog, int id) {
               	   }
               	  });
               	 AlertDialog alert = builder.create();
               	 alert.show();
                }
        });
		 
}
	// Fanta Image Button 
	public void FantaClick() {
		 button = (ImageButton) findViewById(R.id.imagebutton3);
		 button.setOnClickListener(new OnClickListener() {
               @Override
               public void onClick(View arg0) {
              	 
              	 AlertDialog.Builder builder = new AlertDialog.Builder(ItemList10.this);
              	 builder.setTitle(" ");
              	 builder.setIcon(R.drawable.fanta);
              	 builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
              	     public void onClick(DialogInterface dialog, int itemId) {
              	    	item=itemId;
              	  Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
              	     }
              	 });

              	 builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
              	   public void onClick(DialogInterface dialog, int id) {
              		   order10=1;
              		   String order10String=Integer.toString(order10);
              		   save("order10", order10String);
              		   if(item==0){
              	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
              	   smallFantaValue++;
              	   smallFantaPrice=smallFantaPrice +  1.30 ;
              	   String smallFantaValueString=Integer.toString(smallFantaValue);
              	   String smallFantaPriceString=Double.toString(smallFantaPrice);
      				i.putExtra("smallFantaValue", "Small Fanta x " + smallFantaValueString );
      				save("smallFantaValue10", smallFantaValueString);
      				save("smallFantaPrice10", smallFantaPriceString);
              		   }
              		   else if(item==1){
                     	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                     	regularFantaValue++;
                     	regularFantaPrice=regularFantaPrice + 2.30;
                     	 String regularFantaValueString=Integer.toString(regularFantaValue);
                     	String  regularFantaPriceString=Double.toString( regularFantaPrice);
       				i.putExtra("regularFantaValue", "Regular Fanta x " + regularFantaValueString );
       				save("regularFantaValue10", regularFantaValueString);
       				save("smallFantaPrice10", regularFantaPriceString);
       				
                     		   }
              		   else if(item==2){
                        	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                        	  largeFantaValue++;
                        	largeFantaPrice=largeFantaPrice + 3.30;
                        	String largeFantaValueString=Integer.toString(largeFantaValue);
                        	String  largeFantaPriceString=Double.toString( largeFantaPrice);
             				i.putExtra("largeFantaValue", "Large Fanta x " + largeFantaValueString );
             				save("largeFantaValue10", largeFantaValueString);
             				save("largeFantaPrice10", largeFantaPriceString);
                        		   }
              		   else if(item==3){
                        	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                        	  extraLargeFantaValue++;
                        	extraLargeFantaPrice=extraLargeFantaPrice+3.99;
                        	String  extraLargeFantaValueString=Integer.toString(extraLargeFantaValue);
                        	String  extraLargeFantaPriceString=Double.toString( extraLargeFantaPrice);
             				i.putExtra("extraLargeFantaValue","Extra Large Fanta x " + extraLargeFantaValueString );
             				save("extraLargeFantaValue10", extraLargeFantaValueString);
             				save("extraLargeFantaPrice10", extraLargeFantaPriceString);
                        		   }
              		   saveIntent(i);
              		   
              	   }
              	  });
              	 builder.setNegativeButton("No",
              	  new DialogInterface.OnClickListener() {
              	   public void onClick(DialogInterface dialog, int id) {
              	   }
              	  });
              	 AlertDialog alert = builder.create();
              	 alert.show();
               }
       });
		 
}
	// Fish Image Button
	public void FishClick() {
		 button = (ImageButton) findViewById(R.id.imagebutton4);
		 button.setOnClickListener(new OnClickListener() {
              @Override
              public void onClick(View arg0) {
             	 
             	 AlertDialog.Builder builder = new AlertDialog.Builder(ItemList10.this);
             	 builder.setTitle(" ");
             	 builder.setIcon(R.drawable.fish);
             	 builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
             	     public void onClick(DialogInterface dialog, int itemId) {
             	    	item=itemId;
             	  Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
             	     }
             	 });

             	 builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
             	   public void onClick(DialogInterface dialog, int id) {
             		   order10=1;
             		   String order10String=Integer.toString(order10);
             		   save("order10", order10String);
             		   if(item==0){
             	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
             	   smallFishValue++;
             	   smallFishPrice=smallFishPrice +  2.50 ;
             	   String smallFishValueString=Integer.toString(smallFishValue);
             	   String smallFishPriceString=Double.toString(smallFishPrice);
     				i.putExtra("smallFishValue", "Small Battered Fish x " + smallFishValueString );
     				save("smallFishValue10", smallFishValueString);
     				save("smallFishPrice10", smallFishPriceString);
             		   }
             		   else if(item==1){
                    	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                    	regularFishValue++;
                    	regularFishPrice=regularFishPrice + 3.50;
                    	 String regularFishValueString=Integer.toString(regularFishValue);
                    	String  regularFishPriceString=Double.toString( regularFishPrice);
      				i.putExtra("regularFishValue", "Regular Battered Fish x " + regularFishValueString );
      				save("regularFishValue10", regularFishValueString);
      				save("smallFishPrice10", regularFishPriceString);
      				
                    		   }
             		   else if(item==2){
                       	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                       	  largeFishValue++;
                       	largeFishPrice=largeFishPrice + 4.50;
                       	String largeFishValueString=Integer.toString(largeFishValue);
                       	String  largeFishPriceString=Double.toString( largeFishPrice);
            				i.putExtra("largeFishValue", "Large Battered Fish x " + largeFishValueString );
            				save("largeFishValue10", largeFishValueString);
            				save("largeFishPrice10", largeFishPriceString);
                       		   }
             		   else if(item==3){
                       	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                       	  extraLargeFishValue++;
                       	extraLargeFishPrice=extraLargeFishPrice+5.00;
                       	String  extraLargeFishValueString=Integer.toString(extraLargeFishValue);
                       	String  extraLargeFishPriceString=Double.toString( extraLargeFishPrice);
            				i.putExtra("extraLargeFishValue","Extra Large Battered Fish x " + extraLargeFishValueString );
            				save("extraLargeFishValue10", extraLargeFishValueString);
            				save("extraLargeFishPrice10", extraLargeFishPriceString);
                       		   }
             		   saveIntent(i);
             		   
             	   }
             	  });
             	 builder.setNegativeButton("No",
             	  new DialogInterface.OnClickListener() {
             	   public void onClick(DialogInterface dialog, int id) {
             	   }
             	  });
             	 AlertDialog alert = builder.create();
             	 alert.show();
              }
      });
		 
}
	// French Fries Image Button
	public void FriesClick() {
		 button = (ImageButton) findViewById(R.id.imagebutton5);
		 button.setOnClickListener(new OnClickListener() {
             @Override
             public void onClick(View arg0) {
            	 
            	 AlertDialog.Builder builder = new AlertDialog.Builder(ItemList10.this);
            	 builder.setTitle(" ");
            	 builder.setIcon(R.drawable.fries);
            	 builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            	     public void onClick(DialogInterface dialog, int itemId) {
            	    	item=itemId;
            	  Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
            	     }
            	 });

            	 builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            	   public void onClick(DialogInterface dialog, int id) {
            		   order10=1;
            		   String order10String=Integer.toString(order10);
            		   save("order10", order10String);
            		   if(item==0){
            	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
            	   smallFriesValue++;
            	   smallFriesPrice=smallFriesPrice +  1.50 ;
            	   String smallFriesValueString=Integer.toString(smallFriesValue);
            	   String smallFriesPriceString=Double.toString(smallFriesPrice);
    				i.putExtra("smallFriesValue", "Small French Fries x " + smallFriesValueString );
    				save("smallFriesValue10", smallFriesValueString);
    				save("smallFriesPrice10", smallFriesPriceString);
            		   }
            		   else if(item==1){
                   	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                   	regularFriesValue++;
                   	regularFriesPrice=regularFriesPrice + 2.00;
                   	 String regularFriesValueString=Integer.toString(regularFriesValue);
                   	String  regularFriesPriceString=Double.toString( regularFriesPrice);
     				i.putExtra("regularFriesValue", "Regular French Fries x " + regularFriesValueString );
     				save("regularFriesValue10", regularFriesValueString);
     				save("smallFriesPrice10", regularFriesPriceString);
     				
                   		   }
            		   else if(item==2){
                      	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                      	  largeFriesValue++;
                      	largeFriesPrice=largeFriesPrice + 2.50;
                      	String largeFriesValueString=Integer.toString(largeFriesValue);
                      	String  largeFriesPriceString=Double.toString( largeFriesPrice);
           				i.putExtra("largeFriesValue", "Large French Fries x " + largeFriesValueString );
           				save("largeFriesValue10", largeFriesValueString);
           				save("largeFriesPrice10", largeFriesPriceString);
                      		   }
            		   else if(item==3){
                      	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                      	  extraLargeFriesValue++;
                      	extraLargeFriesPrice=extraLargeFriesPrice+3.00;
                      	String  extraLargeFriesValueString=Integer.toString(extraLargeFriesValue);
                      	String  extraLargeFriesPriceString=Double.toString( extraLargeFriesPrice);
           				i.putExtra("extraLargeFriesValue","Extra Large French Fries x " + extraLargeFriesValueString );
           				save("extraLargeFriesValue10", extraLargeFriesValueString);
           				save("extraLargeFriesPrice10", extraLargeFriesPriceString);
                      		   }
            		   saveIntent(i);
            		   
            	   }
            	  });
            	 builder.setNegativeButton("No",
            	  new DialogInterface.OnClickListener() {
            	   public void onClick(DialogInterface dialog, int id) {
            	   }
            	  });
            	 AlertDialog alert = builder.create();
            	 alert.show();
             }
     });
		 
}
	// Pizza Image Button
	public void PizzaClick() {
		 button = (ImageButton) findViewById(R.id.imagebutton6);
		 button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
           	 
           	 AlertDialog.Builder builder = new AlertDialog.Builder(ItemList10.this);
           	 builder.setTitle(" ");
           	 builder.setIcon(R.drawable.pizza);
           	 builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
           	     public void onClick(DialogInterface dialog, int itemId) {
           	    	item=itemId;
           	  Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
           	     }
           	 });

           	 builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           	   public void onClick(DialogInterface dialog, int id) {
           		   order10=1;
           		   String order10String=Integer.toString(order10);
           		   save("order10", order10String);
           		   if(item==0){
           	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
           	   smallPizzaValue++;
           	   smallPizzaPrice=smallPizzaPrice +  3.50 ;
           	   String smallPizzaValueString=Integer.toString(smallPizzaValue);
           	   String smallPizzaPriceString=Double.toString(smallPizzaPrice);
   				i.putExtra("smallPizzaValue", "Small Pepperoni Pizza x " + smallPizzaValueString );
   				save("smallPizzaValue10", smallPizzaValueString);
   				save("smallPizzaPrice10", smallPizzaPriceString);
           		   }
           		   else if(item==1){
                  	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                  	regularPizzaValue++;
                  	regularPizzaPrice=regularPizzaPrice + 5.00;
                  	 String regularPizzaValueString=Integer.toString(regularPizzaValue);
                  	String  regularPizzaPriceString=Double.toString( regularPizzaPrice);
    				i.putExtra("regularPizzaValue", "Regular Pepperoni Pizza x " + regularPizzaValueString );
    				save("regularPizzaValue10", regularPizzaValueString);
    				save("smallPizzaPrice10", regularPizzaPriceString);
    				
                  		   }
           		   else if(item==2){
                     	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                     	  largePizzaValue++;
                     	largePizzaPrice=largePizzaPrice + 7.50;
                     	String largePizzaValueString=Integer.toString(largePizzaValue);
                     	String  largePizzaPriceString=Double.toString( largePizzaPrice);
          				i.putExtra("largePizzaValue", "Large Pepperoni Pizza x " + largePizzaValueString );
          				save("largePizzaValue10", largePizzaValueString);
          				save("largePizzaPrice10", largePizzaPriceString);
                     		   }
           		   else if(item==3){
                     	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                     	  extraLargePizzaValue++;
                     	extraLargePizzaPrice=extraLargePizzaPrice+9.00;
                     	String  extraLargePizzaValueString=Integer.toString(extraLargePizzaValue);
                     	String  extraLargePizzaPriceString=Double.toString( extraLargePizzaPrice);
          				i.putExtra("extraLargePizzaValue","Extra Large Pepperoni Pizza x " + extraLargePizzaValueString );
          				save("extraLargePizzaValue10", extraLargePizzaValueString);
          				save("extraLargePizzaPrice10", extraLargePizzaPriceString);
                     		   }
           		   saveIntent(i);
           		   
           	   }
           	  });
           	 builder.setNegativeButton("No",
           	  new DialogInterface.OnClickListener() {
           	   public void onClick(DialogInterface dialog, int id) {
           	   }
           	  });
           	 AlertDialog alert = builder.create();
           	 alert.show();
            }
    });
		 
}
	// Water Image Button
	public void WaterClick() {
		 button = (ImageButton) findViewById(R.id.imagebutton7);
		 button.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View arg0) {
          	 
          	 AlertDialog.Builder builder = new AlertDialog.Builder(ItemList10.this);
          	 builder.setTitle(" ");
          	 builder.setIcon(R.drawable.water);
          	 builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
          	     public void onClick(DialogInterface dialog, int itemId) {
          	    	item=itemId;
          	  Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
          	     }
          	 });

          	 builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
          	   public void onClick(DialogInterface dialog, int id) {
          		   order10=1;
          		   String order10String=Integer.toString(order10);
          		   save("order10", order10String);
          		   if(item==0){
          	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
          	   smallWaterValue++;
          	   smallWaterPrice=smallWaterPrice +  0.80 ;
          	   String smallWaterValueString=Integer.toString(smallWaterValue);
          	   String smallWaterPriceString=Double.toString(smallWaterPrice);
  				i.putExtra("smallWaterValue", "Small Water x " + smallWaterValueString );
  				save("smallWaterValue10", smallWaterValueString);
  				save("smallWaterPrice10", smallWaterPriceString);
          		   }
          		   else if(item==1){
                 	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                 	regularWaterValue++;
                 	regularWaterPrice=regularWaterPrice + 1.20;
                 	 String regularWaterValueString=Integer.toString(regularWaterValue);
                 	String  regularWaterPriceString=Double.toString( regularWaterPrice);
   				i.putExtra("regularWaterValue", "Regular Water x " + regularWaterValueString );
   				save("regularWaterValue10", regularWaterValueString);
   				save("smallWaterPrice10", regularWaterPriceString);
   				
                 		   }
          		   else if(item==2){
                    	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                    	  largeWaterValue++;
                    	largeWaterPrice=largeWaterPrice + 1.60;
                    	String largeWaterValueString=Integer.toString(largeWaterValue);
                    	String  largeWaterPriceString=Double.toString( largeWaterPrice);
         				i.putExtra("largeWaterValue", "Large Water x " + largeWaterValueString );
         				save("largeWaterValue10", largeWaterValueString);
         				save("largeWaterPrice10", largeWaterPriceString);
                    		   }
          		   else if(item==3){
                    	    Toast.makeText(ItemList10.this, "Order Updated", Toast.LENGTH_SHORT).show();
                    	  extraLargeWaterValue++;
                    	extraLargeWaterPrice=extraLargeWaterPrice+1.90;
                    	String  extraLargeWaterValueString=Integer.toString(extraLargeWaterValue);
                    	String  extraLargeWaterPriceString=Double.toString( extraLargeWaterPrice);
         				i.putExtra("extraLargeWaterValue","Extra Large Water x " + extraLargeWaterValueString );
         				save("extraLargeWaterValue10", extraLargeWaterValueString);
         				save("extraLargeWaterPrice10", extraLargeWaterPriceString);
                    		   }
          		   saveIntent(i);
          		   
          	   }
          	  });
          	 builder.setNegativeButton("No",
          	  new DialogInterface.OnClickListener() {
          	   public void onClick(DialogInterface dialog, int id) {
          	   }
          	  });
          	 AlertDialog alert = builder.create();
          	 alert.show();
           }
   });
		 
}

	// Method used to save string data using Java Output
	 private void save(String filename, String data)
	 {
	     try
	     {
	         FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
	         fos.write(data.getBytes());
	         fos.close();
	     }
	     catch (Exception ex)
	     {
	        ex.printStackTrace();
	     }
	 }
	 
	// Method used to restore string data using Java Input
	 private String load(String filename)
	 {
	     try
	     {
	         FileInputStream fis = openFileInput(filename);
	         BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
	         String line = null, input="";
	         while ((line = reader.readLine()) != null)
	             input += line;
	         reader.close();
	         fis.close();
	         return input;
	     }
	     catch (Exception ex)
	     {
	        return "";
	     }
	 }
	 
	 /**
		 * The Following Methods involve restoring
		 * and reseting all the variables pertaining
		 * to the particular table's order
		 */
	 
	// Restore all the item variables for the specfic table
	private void restoreValueVariables() {
		try {
			String order10String = Integer.toString(order10);
			order10String = load("order10");
			order10 = Integer.parseInt(order10String);
		} catch (Exception e) {
			
		}
		try {
			String smallBurgerValueString = Integer.toString(smallBurgerValue);
			smallBurgerValueString = load("smallBurgerValue10");
			smallBurgerValue = Integer.parseInt(smallBurgerValueString);
		} catch (Exception e) {
			
		}

		try {
			String regularBurgerValueString = Integer
					.toString(regularBurgerValue);
			regularBurgerValueString = load("regularBurgerValue10");
			regularBurgerValue = Integer.parseInt(regularBurgerValueString);
		} catch (Exception e) {
			
		}
		try {
			String largeBurgerValueString = Integer.toString(largeBurgerValue);
			largeBurgerValueString = load("largeBurgerValue10");
			largeBurgerValue = Integer.parseInt(largeBurgerValueString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeBurgerValueString = Integer
					.toString(extraLargeBurgerValue);
			extraLargeBurgerValueString = load("extraLargeBurgerValue10");
			extraLargeBurgerValue = Integer
					.parseInt(extraLargeBurgerValueString);
		} catch (Exception e) {
			
		}
		try {
			String smallChickenBurgerValueString = Integer
					.toString(smallChickenBurgerValue);
			smallChickenBurgerValueString = load("smallChickenBurgerValue10");
			smallChickenBurgerValue = Integer
					.parseInt(smallChickenBurgerValueString);
		} catch (Exception e) {
			
		}

		try {
			String regularChickenBurgerValueString = Integer
					.toString(regularChickenBurgerValue);
			regularChickenBurgerValueString = load("regularChickenBurgerValue10");
			regularChickenBurgerValue = Integer
					.parseInt(regularChickenBurgerValueString);
		} catch (Exception e) {
			
		}
		try {
			String largeChickenBurgerValueString = Integer
					.toString(largeChickenBurgerValue);
			largeChickenBurgerValueString = load("largeChickenBurgerValue10");
			largeChickenBurgerValue = Integer
					.parseInt(largeChickenBurgerValueString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeChickenBurgerValueString = Integer
					.toString(extraLargeChickenBurgerValue);
			extraLargeChickenBurgerValueString = load("extraLargeChickenBurgerValue10");
			extraLargeChickenBurgerValue = Integer
					.parseInt(extraLargeChickenBurgerValueString);
		} catch (Exception e) {
			
		}
		try {
			String smallCokeValueString = Integer.toString(smallCokeValue);
			smallCokeValueString = load("smallCokeValue10");
			smallCokeValue = Integer.parseInt(smallCokeValueString);
		} catch (Exception e) {
			
		}

		try {
			String regularCokeValueString = Integer.toString(regularCokeValue);
			regularCokeValueString = load("regularCokeValue10");
			regularCokeValue = Integer.parseInt(regularCokeValueString);
		} catch (Exception e) {
			
		}
		try {
			String largeCokeValueString = Integer.toString(largeCokeValue);
			largeCokeValueString = load("largeCokeValue10");
			largeCokeValue = Integer.parseInt(largeCokeValueString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeCokeValueString = Integer
					.toString(extraLargeCokeValue);
			extraLargeCokeValueString = load("extraLargeCokeValue10");
			extraLargeCokeValue = Integer.parseInt(extraLargeCokeValueString);
		} catch (Exception e) {
			
		}
		try {
			String smallFantaValueString = Integer.toString(smallFantaValue);
			smallFantaValueString = load("smallFantaValue10");
			smallFantaValue = Integer.parseInt(smallFantaValueString);
		} catch (Exception e) {
			
		}

		try {
			String regularFantaValueString = Integer
					.toString(regularFantaValue);
			regularFantaValueString = load("regularFantaValue10");
			regularFantaValue = Integer.parseInt(regularFantaValueString);
		} catch (Exception e) {
			
		}
		try {
			String largeFantaValueString = Integer.toString(largeFantaValue);
			largeFantaValueString = load("largeFantaValue10");
			largeFantaValue = Integer.parseInt(largeFantaValueString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeFantaValueString = Integer
					.toString(extraLargeFantaValue);
			extraLargeFantaValueString = load("extraLargeFantaValue10");
			extraLargeFantaValue = Integer.parseInt(extraLargeFantaValueString);
		} catch (Exception e) {
			
		}
		try {
			String smallFishValueString = Integer.toString(smallFishValue);
			smallFishValueString = load("smallFishValue10");
			smallFishValue = Integer.parseInt(smallFishValueString);
		} catch (Exception e) {
			
		}

		try {
			String regularFishValueString = Integer.toString(regularFishValue);
			regularFishValueString = load("regularFishValue10");
			regularFishValue = Integer.parseInt(regularFishValueString);
		} catch (Exception e) {
			
		}
		try {
			String largeFishValueString = Integer.toString(largeFishValue);
			largeFishValueString = load("largeFishValue10");
			largeFishValue = Integer.parseInt(largeFishValueString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeFishValueString = Integer
					.toString(extraLargeFishValue);
			extraLargeFishValueString = load("extraLargeFishValue10");
			extraLargeFishValue = Integer.parseInt(extraLargeFishValueString);
		} catch (Exception e) {
			
		}
		try {
			String smallFriesValueString = Integer.toString(smallFriesValue);
			smallFriesValueString = load("smallFriesValue10");
			smallFriesValue = Integer.parseInt(smallFriesValueString);
		} catch (Exception e) {
			
		}

		try {
			String regularFriesValueString = Integer
					.toString(regularFriesValue);
			regularFriesValueString = load("regularFriesValue10");
			regularFriesValue = Integer.parseInt(regularFriesValueString);
		} catch (Exception e) {
		
		}
		try {
			String largeFriesValueString = Integer.toString(largeFriesValue);
			largeFriesValueString = load("largeFriesValue10");
			largeFriesValue = Integer.parseInt(largeFriesValueString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeFriesValueString = Integer
					.toString(extraLargeFriesValue);
			extraLargeFriesValueString = load("extraLargeFriesValue10");
			extraLargeFriesValue = Integer.parseInt(extraLargeFriesValueString);
		} catch (Exception e) {
			
		}
		try {
			String smallPizzaValueString = Integer.toString(smallPizzaValue);
			smallPizzaValueString = load("smallPizzaValue10");
			smallPizzaValue = Integer.parseInt(smallPizzaValueString);
		} catch (Exception e) {
			
		}

		try {
			String regularPizzaValueString = Integer
					.toString(regularPizzaValue);
			regularPizzaValueString = load("regularPizzaValue10");
			regularPizzaValue = Integer.parseInt(regularPizzaValueString);
		} catch (Exception e) {
			
		}
		try {
			String largePizzaValueString = Integer.toString(largePizzaValue);
			largePizzaValueString = load("largePizzaValue10");
			largePizzaValue = Integer.parseInt(largePizzaValueString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargePizzaValueString = Integer
					.toString(extraLargePizzaValue);
			extraLargePizzaValueString = load("extraLargePizzaValue10");
			extraLargePizzaValue = Integer.parseInt(extraLargePizzaValueString);
		} catch (Exception e) {
			
		}
		try {
			String smallWaterValueString = Integer.toString(smallWaterValue);
			smallWaterValueString = load("smallWaterValue10");
			smallWaterValue = Integer.parseInt(smallWaterValueString);
		} catch (Exception e) {
			
		}

		try {
			String regularWaterValueString = Integer
					.toString(regularWaterValue);
			regularWaterValueString = load("regularWaterValue10");
			regularWaterValue = Integer.parseInt(regularWaterValueString);
		} catch (Exception e) {
		
		}
		try {
			String largeWaterValueString = Integer.toString(largeWaterValue);
			largeWaterValueString = load("largeWaterValue10");
			largeWaterValue = Integer.parseInt(largeWaterValueString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeWaterValueString = Integer
					.toString(extraLargeWaterValue);
			extraLargeWaterValueString = load("extraLargeWaterValue10");
			extraLargeWaterValue = Integer.parseInt(extraLargeWaterValueString);
		} catch (Exception e) {
			
		}
	}
	// Restore all the item prices for the specfic table
	private void restorePriceVariables() {
		try {
			String smallBurgerPriceString = Double.toString(smallBurgerPrice);
			smallBurgerPriceString = load("smallBurgerPrice10");
			smallBurgerPrice = Double.parseDouble(smallBurgerPriceString);
		} catch (Exception e) {
			
		}
		try {
			String regularBurgerPriceString = Double
					.toString(regularBurgerPrice);
			regularBurgerPriceString = load("regularBurgerPrice10");
			regularBurgerPrice = Double.parseDouble(regularBurgerPriceString);
		} catch (Exception e) {
			
		}
		try {
			String largeBurgerPriceString = Double.toString(largeBurgerPrice);
			largeBurgerPriceString = load("largeBurgerPrice10");
			largeBurgerPrice = Double.parseDouble(largeBurgerPriceString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeBurgerPriceString = Double
					.toString(extraLargeBurgerPrice);
			extraLargeBurgerPriceString = load("extraLargeBurgerPrice10");
			extraLargeBurgerPrice = Double
					.parseDouble(extraLargeBurgerPriceString);
		} catch (Exception e) {
			
		}
		try {
			String smallChickenBurgerPriceString = Double
					.toString(smallChickenBurgerPrice);
			smallChickenBurgerPriceString = load("smallChickenBurgerPrice10");
			smallChickenBurgerPrice = Double
					.parseDouble(smallChickenBurgerPriceString);
		} catch (Exception e) {
			
		}
		try {
			String regularChickenBurgerPriceString = Double
					.toString(regularChickenBurgerPrice);
			regularChickenBurgerPriceString = load("regularChickenBurgerPrice10");
			regularChickenBurgerPrice = Double
					.parseDouble(regularChickenBurgerPriceString);
		} catch (Exception e) {
			
		}
		try {
			String largeChickenBurgerPriceString = Double
					.toString(largeChickenBurgerPrice);
			largeChickenBurgerPriceString = load("largeChickenBurgerPrice10");
			largeChickenBurgerPrice = Double
					.parseDouble(largeChickenBurgerPriceString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeChickenBurgerPriceString = Double
					.toString(extraLargeChickenBurgerPrice);
			extraLargeChickenBurgerPriceString = load("extraLargeChickenBurgerPrice10");
			extraLargeChickenBurgerPrice = Double
					.parseDouble(extraLargeChickenBurgerPriceString);
		} catch (Exception e) {
			
		}
		try {
			String smallCokePriceString = Double.toString(smallCokePrice);
			smallCokePriceString = load("smallCokePrice10");
			smallCokePrice = Double.parseDouble(smallCokePriceString);
		} catch (Exception e) {
			
		}
		try {
			String regularCokePriceString = Double.toString(regularCokePrice);
			regularCokePriceString = load("regularCokePrice10");
			regularCokePrice = Double.parseDouble(regularCokePriceString);
		} catch (Exception e) {
			
		}
		try {
			String largeCokePriceString = Double.toString(largeCokePrice);
			largeCokePriceString = load("largeCokePrice10");
			largeCokePrice = Double.parseDouble(largeCokePriceString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeCokePriceString = Double
					.toString(extraLargeCokePrice);
			extraLargeCokePriceString = load("extraLargeCokePrice10");
			extraLargeCokePrice = Double.parseDouble(extraLargeCokePriceString);
		} catch (Exception e) {
			
		}
		try {
			String smallFantaPriceString = Double.toString(smallFantaPrice);
			smallFantaPriceString = load("smallFantaPrice10");
			smallFantaPrice = Double.parseDouble(smallFantaPriceString);
		} catch (Exception e) {
			
		}
		try {
			String regularFantaPriceString = Double.toString(regularFantaPrice);
			regularFantaPriceString = load("regularFantaPrice10");
			regularFantaPrice = Double.parseDouble(regularFantaPriceString);
		} catch (Exception e) {
			
		}
		try {
			String largeFantaPriceString = Double.toString(largeFantaPrice);
			largeFantaPriceString = load("largeFantaPrice10");
			largeFantaPrice = Double.parseDouble(largeFantaPriceString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeFantaPriceString = Double
					.toString(extraLargeFantaPrice);
			extraLargeFantaPriceString = load("extraLargeFantaPrice10");
			extraLargeFantaPrice = Double
					.parseDouble(extraLargeFantaPriceString);
		} catch (Exception e) {
			
		}
		try {
			String smallFishPriceString = Double.toString(smallFishPrice);
			smallFishPriceString = load("smallFishPrice10");
			smallFishPrice = Double.parseDouble(smallFishPriceString);
		} catch (Exception e) {
			
		}
		try {
			String regularFishPriceString = Double.toString(regularFishPrice);
			regularFishPriceString = load("regularFishPrice10");
			regularFishPrice = Double.parseDouble(regularFishPriceString);
		} catch (Exception e) {
			
		}
		try {
			String largeFishPriceString = Double.toString(largeFishPrice);
			largeFishPriceString = load("largeFishPrice10");
			largeFishPrice = Double.parseDouble(largeFishPriceString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeFishPriceString = Double
					.toString(extraLargeFishPrice);
			extraLargeFishPriceString = load("extraLargeFishPrice10");
			extraLargeFishPrice = Double.parseDouble(extraLargeFishPriceString);
		} catch (Exception e) {
			
		}
		try {
			String smallFriesPriceString = Double.toString(smallFriesPrice);
			smallFriesPriceString = load("smallFriesPrice10");
			smallFriesPrice = Double.parseDouble(smallFriesPriceString);
		} catch (Exception e) {
			
		}
		try {
			String regularFriesPriceString = Double.toString(regularFriesPrice);
			regularFriesPriceString = load("regularFriesPrice10");
			regularFriesPrice = Double.parseDouble(regularFriesPriceString);
		} catch (Exception e) {
			
		}
		try {
			String largeFriesPriceString = Double.toString(largeFriesPrice);
			largeFriesPriceString = load("largeFriesPrice10");
			largeFriesPrice = Double.parseDouble(largeFriesPriceString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeFriesPriceString = Double
					.toString(extraLargeFriesPrice);
			extraLargeFriesPriceString = load("extraLargeFriesPrice10");
			extraLargeFriesPrice = Double
					.parseDouble(extraLargeFriesPriceString);
		} catch (Exception e) {
			
		}
		try {
			String smallPizzaPriceString = Double.toString(smallPizzaPrice);
			smallPizzaPriceString = load("smallPizzaPrice10");
			smallPizzaPrice = Double.parseDouble(smallPizzaPriceString);
		} catch (Exception e) {
			
		}
		try {
			String regularPizzaPriceString = Double.toString(regularPizzaPrice);
			regularPizzaPriceString = load("regularPizzaPrice10");
			regularPizzaPrice = Double.parseDouble(regularPizzaPriceString);
		} catch (Exception e) {
			
		}
		try {
			String largePizzaPriceString = Double.toString(largePizzaPrice);
			largePizzaPriceString = load("largePizzaPrice10");
			largePizzaPrice = Double.parseDouble(largePizzaPriceString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargePizzaPriceString = Double
					.toString(extraLargePizzaPrice);
			extraLargePizzaPriceString = load("extraLargePizzaPrice10");
			extraLargePizzaPrice = Double
					.parseDouble(extraLargePizzaPriceString);
		} catch (Exception e) {
			
		}
		try {
			String smallWaterPriceString = Double.toString(smallWaterPrice);
			smallWaterPriceString = load("smallWaterPrice10");
			smallWaterPrice = Double.parseDouble(smallWaterPriceString);
		} catch (Exception e) {
			
		}
		try {
			String regularWaterPriceString = Double.toString(regularWaterPrice);
			regularWaterPriceString = load("regularWaterPrice10");
			regularWaterPrice = Double.parseDouble(regularWaterPriceString);
		} catch (Exception e) {
			
		}
		try {
			String largeWaterPriceString = Double.toString(largeWaterPrice);
			largeWaterPriceString = load("largeWaterPrice10");
			largeWaterPrice = Double.parseDouble(largeWaterPriceString);
		} catch (Exception e) {
			
		}
		try {
			String extraLargeWaterPriceString = Double
					.toString(extraLargeWaterPrice);
			extraLargeWaterPriceString = load("extraLargeWaterPrice10");
			extraLargeWaterPrice = Double
					.parseDouble(extraLargeWaterPriceString);
		} catch (Exception e) {
			
		}

	}
	// Reset all the item variables for the specfic table
	private void resetValueVariables() {
		order10 = 0;
		String order10String = Integer.toString(order10);
		save("order10", order10String);

		message10 = null;
		save("message10", message10);

		smallBurgerValue = 0;
		String smallBurgerValueString = Integer.toString(smallBurgerValue);
		save("smallBurgerValue10", smallBurgerValueString);

		regularBurgerValue = 0;
		String regularBurgerValueString = Integer.toString(regularBurgerValue);
		save("regularBurgerValue10", regularBurgerValueString);

		largeBurgerValue = 0;
		String largeBurgerValueString = Integer.toString(largeBurgerValue);
		save("largeBurgerValue10", largeBurgerValueString);

		extraLargeBurgerValue = 0;
		String extraLargeBurgerValueString = Integer
				.toString(extraLargeBurgerValue);
		save("extraLargeBurgerValue10", extraLargeBurgerValueString);

		smallChickenBurgerValue = 0;
		String smallChickenBurgerValueString = Integer
				.toString(smallChickenBurgerValue);
		save("smallChickenBurgerValue10", smallChickenBurgerValueString);

		regularChickenBurgerValue = 0;
		String regularChickenBurgerValueString = Integer
				.toString(regularChickenBurgerValue);
		save("regularChickenBurgerValue10", regularChickenBurgerValueString);

		largeChickenBurgerValue = 0;
		String largeChickenBurgerValueString = Integer
				.toString(largeChickenBurgerValue);
		save("largeChickenBurgerValue10", largeChickenBurgerValueString);

		extraLargeChickenBurgerValue = 0;
		String extraLargeChickenBurgerValueString = Integer
				.toString(extraLargeChickenBurgerValue);
		save("extraLargeChickenBurgerValue10",
				extraLargeChickenBurgerValueString);

		smallCokeValue = 0;
		String smallCokeValueString = Integer.toString(smallCokeValue);
		save("smallCokeValue10", smallCokeValueString);

		regularCokeValue = 0;
		String regularCokeValueString = Integer.toString(regularCokeValue);
		save("regularCokeValue10", regularCokeValueString);

		largeCokeValue = 0;
		String largeCokeValueString = Integer.toString(largeCokeValue);
		save("largeCokeValue10", largeCokeValueString);

		extraLargeCokeValue = 0;
		String extraLargeCokeValueString = Integer
				.toString(extraLargeCokeValue);
		save("extraLargeCokeValue10", extraLargeCokeValueString);

		smallFantaValue = 0;
		String smallFantaValueString = Integer.toString(smallFantaValue);
		save("smallFantaValue10", smallFantaValueString);

		regularFantaValue = 0;
		String regularFantaValueString = Integer.toString(regularFantaValue);
		save("regularFantaValue10", regularFantaValueString);

		largeFantaValue = 0;
		String largeFantaValueString = Integer.toString(largeFantaValue);
		save("largeFantaValue10", largeFantaValueString);

		extraLargeFantaValue = 0;
		String extraLargeFantaValueString = Integer
				.toString(extraLargeFantaValue);
		save("extraLargeFantaValue10", extraLargeFantaValueString);

		smallFishValue = 0;
		String smallFishValueString = Integer.toString(smallFishValue);
		save("smallFishValue10", smallFishValueString);

		regularFishValue = 0;
		String regularFishValueString = Integer.toString(regularFishValue);
		save("regularFishValue10", regularFishValueString);

		largeFishValue = 0;
		String largeFishValueString = Integer.toString(largeFishValue);
		save("largeFishValue10", largeFishValueString);

		extraLargeFishValue = 0;
		String extraLargeFishValueString = Integer
				.toString(extraLargeFishValue);
		save("extraLargeFishValue10", extraLargeFishValueString);

		smallFriesValue = 0;
		String smallFriesValueString = Integer.toString(smallFriesValue);
		save("smallFriesValue10", smallFriesValueString);

		regularFriesValue = 0;
		String regularFriesValueString = Integer.toString(regularFriesValue);
		save("regularFriesValue10", regularFriesValueString);

		largeFriesValue = 0;
		String largeFriesValueString = Integer.toString(largeFriesValue);
		save("largeFriesValue10", largeFriesValueString);

		extraLargeFriesValue = 0;
		String extraLargeFriesValueString = Integer
				.toString(extraLargeFriesValue);
		save("extraLargeFriesValue10", extraLargeFriesValueString);

		smallPizzaValue = 0;
		String smallPizzaValueString = Integer.toString(smallPizzaValue);
		save("smallPizzaValue10", smallPizzaValueString);

		regularPizzaValue = 0;
		String regularPizzaValueString = Integer.toString(regularPizzaValue);
		save("regularPizzaValue10", regularPizzaValueString);

		largePizzaValue = 0;
		String largePizzaValueString = Integer.toString(largePizzaValue);
		save("largePizzaValue10", largePizzaValueString);

		extraLargePizzaValue = 0;
		String extraLargePizzaValueString = Integer
				.toString(extraLargePizzaValue);
		save("extraLargePizzaValue10", extraLargePizzaValueString);

		smallWaterValue = 0;
		String smallWaterValueString = Integer.toString(smallWaterValue);
		save("smallWaterValue10", smallWaterValueString);

		regularWaterValue = 0;
		String regularWaterValueString = Integer.toString(regularWaterValue);
		save("regularWaterValue10", regularWaterValueString);

		largeWaterValue = 0;
		String largeWaterValueString = Integer.toString(largeWaterValue);
		save("largeWaterValue10", largeWaterValueString);

		extraLargeWaterValue = 0;
		String extraLargeWaterValueString = Integer
				.toString(extraLargeWaterValue);
		save("extraLargeWaterValue10", extraLargeWaterValueString);
	}

	// Reset all the item prices for the specfic table
	private void resetPriceVariables() {
		smallBurgerPrice = 0;
		String smallBurgerPriceString = Double.toString(smallBurgerPrice);
		save("smallBurgerPrice10", smallBurgerPriceString);

		regularBurgerPrice = 0;
		String regularBurgerPriceString = Double.toString(regularBurgerPrice);
		save("regularBurgerPrice10", regularBurgerPriceString);

		largeBurgerPrice = 0;
		String largeBurgerPriceString = Double.toString(largeBurgerPrice);
		save("largeBurgerPrice10", largeBurgerPriceString);

		extraLargeBurgerPrice = 0;
		String extraLargeBurgerPriceString = Double
				.toString(extraLargeBurgerPrice);
		save("extraLargeBurgerPrice10", extraLargeBurgerPriceString);

		smallChickenBurgerPrice = 0;
		String smallChickenBurgerPriceString = Double
				.toString(smallChickenBurgerPrice);
		save("smallChickenBurgerPrice10", smallChickenBurgerPriceString);

		regularChickenBurgerPrice = 0;
		String regularChickenBurgerPriceString = Double
				.toString(regularChickenBurgerPrice);
		save("regularChickenBurgerPrice10", regularChickenBurgerPriceString);

		largeChickenBurgerPrice = 0;
		String largeChickenBurgerPriceString = Double
				.toString(largeChickenBurgerPrice);
		save("largeChickenBurgerPrice10", largeChickenBurgerPriceString);

		extraLargeChickenBurgerPrice = 0;
		String extraLargeChickenBurgerPriceString = Double
				.toString(extraLargeChickenBurgerPrice);
		save("extraLargeChickenBurgerPrice10",
				extraLargeChickenBurgerPriceString);

		smallCokePrice = 0;
		String smallCokePriceString = Double.toString(smallCokePrice);
		save("smallCokePrice10", smallCokePriceString);

		regularCokePrice = 0;
		String regularCokePriceString = Double.toString(regularCokePrice);
		save("regularCokePrice10", regularCokePriceString);

		largeCokePrice = 0;
		String largeCokePriceString = Double.toString(largeCokePrice);
		save("largeCokePrice10", largeCokePriceString);

		extraLargeCokePrice = 0;
		String extraLargeCokePriceString = Double.toString(extraLargeCokePrice);
		save("extraLargeCokePrice10", extraLargeCokePriceString);

		smallFantaPrice = 0;
		String smallFantaPriceString = Double.toString(smallFantaPrice);
		save("smallFantaPrice10", smallFantaPriceString);

		regularFantaPrice = 0;
		String regularFantaPriceString = Double.toString(regularFantaPrice);
		save("regularFantaPrice10", regularFantaPriceString);

		largeFantaPrice = 0;
		String largeFantaPriceString = Double.toString(largeFantaPrice);
		save("largeFantaPrice10", largeFantaPriceString);

		extraLargeFantaPrice = 0;
		String extraLargeFantaPriceString = Double
				.toString(extraLargeFantaPrice);
		save("extraLargeFantaPrice10", extraLargeFantaPriceString);

		smallFishPrice = 0;
		String smallFishPriceString = Double.toString(smallFishPrice);
		save("smallFishPrice10", smallFishPriceString);

		regularFishPrice = 0;
		String regularFishPriceString = Double.toString(regularFishPrice);
		save("regularFishPrice10", regularFishPriceString);

		largeFishPrice = 0;
		String largeFishPriceString = Double.toString(largeFishPrice);
		save("largeFishPrice10", largeFishPriceString);

		extraLargeFishPrice = 0;
		String extraLargeFishPriceString = Double.toString(extraLargeFishPrice);
		save("extraLargeFishPrice10", extraLargeFishPriceString);

		smallFriesPrice = 0;
		String smallFriesPriceString = Double.toString(smallFriesPrice);
		save("smallFriesPrice10", smallFriesPriceString);

		regularFriesPrice = 0;
		String regularFriesPriceString = Double.toString(regularFriesPrice);
		save("regularFriesPrice10", regularFriesPriceString);

		largeFriesPrice = 0;
		String largeFriesPriceString = Double.toString(largeFriesPrice);
		save("largeFriesPrice10", largeFriesPriceString);

		extraLargeFriesPrice = 0;
		String extraLargeFriesPriceString = Double
				.toString(extraLargeFriesPrice);
		save("extraLargeFriesPrice10", extraLargeFriesPriceString);

		smallPizzaPrice = 0;
		String smallPizzaPriceString = Double.toString(smallPizzaPrice);
		save("smallPizzaPrice10", smallPizzaPriceString);

		regularPizzaPrice = 0;
		String regularPizzaPriceString = Double.toString(regularPizzaPrice);
		save("regularPizzaPrice10", regularPizzaPriceString);

		largePizzaPrice = 0;
		String largePizzaPriceString = Double.toString(largePizzaPrice);
		save("largePizzaPrice10", largePizzaPriceString);

		extraLargePizzaPrice = 0;
		String extraLargePizzaPriceString = Double
				.toString(extraLargePizzaPrice);
		save("extraLargePizzaPrice10", extraLargePizzaPriceString);

		smallWaterPrice = 0;
		String smallWaterPriceString = Double.toString(smallWaterPrice);
		save("smallWaterPrice10", smallWaterPriceString);

		regularWaterPrice = 0;
		String regularWaterPriceString = Double.toString(regularWaterPrice);
		save("regularWaterPrice10", regularWaterPriceString);

		largeWaterPrice = 0;
		String largeWaterPriceString = Double.toString(largeWaterPrice);
		save("largeWaterPrice10", largeWaterPriceString);

		extraLargeWaterPrice = 0;
		String extraLargeWaterPriceString = Double
				.toString(extraLargeWaterPrice);
		save("extraLargeWaterPrice10", extraLargeWaterPriceString);

	}
}
