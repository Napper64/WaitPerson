package com.example.orders;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.example.waitperson.R;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;

public class Order06 extends ActionBarActivity implements OnItemSelectedListener {

	
	private Button makeComment;
	private EditText editText;
	private double totalPrice;
	private double tip;
	private double VatPrice;
	private double VAT;
	private double exVatPrice;
	private RelativeLayout mainLayout;
	private TextView itemListView;
	private TextView priceListView;
	private List<Object> list=new ArrayList<Object>();
	private Button calculateBill;
	private static ProgressBar m_progressBar; //UI reference
	private int percent_done = 0;
	private double smallBurgerPrice;
	private double regularBurgerPrice;
	private double largeBurgerPrice;
	private double extraLargeBurgerPrice;
	private double smallChickenBurgerPrice;
	private double regularChickenBurgerPrice;
	private double largeChickenBurgerPrice;
	private double extraLargeChickenBurgerPrice;
	private double smallCokePrice;
	private double regularCokePrice;
	private double largeCokePrice;
	private double extraLargeCokePrice;
	private double smallFantaPrice;
	private double regularFantaPrice;
	private double largeFantaPrice;
	private double extraLargeFantaPrice;
	private double smallFishPrice;
	private double regularFishPrice;
	private double largeFishPrice;
	private double extraLargeFishPrice;
	private double smallFriesPrice;
	private double regularFriesPrice;
	private double largeFriesPrice;
	private double extraLargeFriesPrice;
	private double smallPizzaPrice;
	private double regularPizzaPrice;
	private double largePizzaPrice;
	private double extraLargePizzaPrice;
	private double smallWaterPrice;
	private double regularWaterPrice;
	private double largeWaterPrice;
	private double extraLargeWaterPrice;
	
	
	final Handler mHandler = new Handler();
	// Create runnable for posting results to the UI thread
	final Runnable mUpdateResults = new Runnable() {
		public void run() {
			if (m_progressBar != null)
				m_progressBar.setProgress(percent_done);
	}
	};
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order06);
		mainLayout = (RelativeLayout) findViewById(R.id.main);

		// Create Relative Layout Programmatically
		RelativeLayout lView = new RelativeLayout(this);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.BELOW, 44);
		lView.setId(88);
		mainLayout.addView(lView, lp);
		itemListView = new TextView(this);
		lView.addView(itemListView);
		priceListView = new TextView(this);
		lView.addView(priceListView);

		// Create EditText widget Programmatically
		editText = new EditText(this);
		editText.setId(66);
		RelativeLayout.LayoutParams editTextParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		editTextParams.addRule(RelativeLayout.BELOW, 88);
		editTextParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		editTextParams.addRule(RelativeLayout.CENTER_VERTICAL);
		editText.setHint("Enter Additional Info for Chef");
		mainLayout.addView(editText, editTextParams);

		// Create Spinner widget Programmatically
		Spinner spinner = new Spinner(this);
		spinner.setId(44);
		RelativeLayout.LayoutParams spinnerParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		mainLayout.addView(spinner, spinnerParams);
		spinner.setOnItemSelectedListener(this);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.spinner_array,
				android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);

		// Create Button widget Programmatically
		calculateBill = new Button(this);
		calculateBill.setId(55);
		RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);
		mainLayout.addView(calculateBill, buttonParams);
		calculateBill.setText("Calculate Total Bill");

		// Create Second Button widget Programmatically
		makeComment = new Button(this);
		makeComment.setId(77);
		RelativeLayout.LayoutParams makeCommentParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		makeCommentParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		makeCommentParams.addRule(RelativeLayout.CENTER_VERTICAL);
		makeCommentParams.addRule(RelativeLayout.BELOW, 66);
		mainLayout.addView(makeComment, makeCommentParams);
		makeComment.setText("Submit Comment");

		// Create ProgressBar widget Programmatically
		m_progressBar = new ProgressBar(this, null,
				android.R.attr.progressBarStyleHorizontal);
		m_progressBar.setVisibility(View.GONE);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				500, 1000);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		params.addRule(RelativeLayout.BELOW, 66);
		mainLayout.addView(m_progressBar, params);

		// Set an escape arrow on the action bar next to the icon
		getActionBar().setDisplayHomeAsUpEnabled(true);

	};
				
		
				
	// Method used to List all the Items currently Ordered
	private void showItems() {

		Bundle extras = this.getIntent().getExtras();
		if (extras == null) {
			itemListView.setTextSize(15);
			itemListView.append("\n");
			itemListView.append("Table 6 has not ordered yet" + "\n");
			itemListView.append("\n");
		}
		if (extras != null) {
			Set<String> keys = extras.keySet();
			Iterator<String> it = keys.iterator();
			while (it.hasNext()) {
				String key = it.next();
				list.add(extras.get(key));

			}
			itemListView.setTextSize(15);
			itemListView.append("\n");
			itemListView.append("Table 6 has ordered the following items"
					+ "\n");
			itemListView.append("\n");
			for (int i = 0; i < list.size(); i++) {
				itemListView.append((CharSequence) list.get(i));
				itemListView.append("\n");
			}
		}
		String message = load("message06");
		itemListView.append("\n");
		itemListView.append(message);
		itemListView.append("\n");

	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.order06, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		if (pos == 0) {
			priceListView.setText("");
			showItems();
			makeComment();
			makeComment.setVisibility(View.VISIBLE);
			editText.setVisibility(View.VISIBLE);
			calculateBill.setVisibility(View.GONE);
			m_progressBar.setVisibility(View.GONE);
		} else if (pos == 1) {
			list.clear();
			itemListView.setText("");
			makeComment.setVisibility(View.GONE);
			editText.setVisibility(View.GONE);
			calculateBill.setVisibility(View.VISIBLE);
			showBill();
		}
	}

	// Method used to add comment when button is clicked
	private void makeComment() {
		makeComment.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String message = editText.getText().toString();
				save("message06", message);
				list.clear();
				editText.setText("");
				itemListView.setText("");
				showItems();
			}
		});
	}


	// Shows the bill when the spinner selects "Bill"
	private void showBill() {

		calculateBill.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// when calculate is clicked the button is hidden and the
				// progress bar displays
				calculateBill.setVisibility(View.GONE);
				m_progressBar.setVisibility(View.VISIBLE);
				do_work();
				calculateBill();
				calculateVatTip();

				priceListView.setTextSize(20);
				Typeface face = Typeface.createFromAsset(getAssets(),
			            "font/courier.ttf");
				priceListView.setTypeface(face);
				priceListView.append("\n");
				priceListView.append("Table 6 cost for the meal is ");
				priceListView.append("\n");
				priceListView.append("\n");
				priceListView.append("Items excluding VAT: " + "€"
						+ round(exVatPrice, 2));
				priceListView.append("\n");
				priceListView.append("VAT Calculated: " + "€" + round(VAT, 2));
				priceListView.append("\n");
				priceListView.append("Service Charge: " + "€" + round(tip, 2));
				priceListView.append("\n");
				priceListView.append("*************************");
				priceListView.append("\n");
				priceListView.append("Total Amount Due: " + "€"
						+ round(totalPrice, 2));

			}

		});

	}

	// Calculates the VAT and Tip for the order
	private void calculateVatTip() {
		VAT = (exVatPrice / 100) * 10;
		VatPrice = exVatPrice + VAT;
		tip = (VatPrice / 100) * 14;
		totalPrice = VatPrice + tip;

	}

     // Calculates the total Bill (excluding VAT and Tip)
		private void calculateBill() {
			 getPrices();
		exVatPrice = smallBurgerPrice + regularBurgerPrice + largeBurgerPrice + extraLargeBurgerPrice 
				+ smallChickenBurgerPrice + regularChickenBurgerPrice + largeChickenBurgerPrice + extraLargeChickenBurgerPrice 
				+ smallCokePrice + regularCokePrice + largeCokePrice + extraLargeCokePrice
				+ smallFantaPrice + regularFantaPrice + largeFantaPrice + extraLargeFantaPrice
				+ smallFishPrice + regularFishPrice + largeFishPrice + extraLargeFishPrice
				+ smallFriesPrice + regularFriesPrice + largeFriesPrice + extraLargeFriesPrice
				+ smallPizzaPrice + regularPizzaPrice + largePizzaPrice + extraLargePizzaPrice
				+ smallWaterPrice + regularWaterPrice + largeWaterPrice + extraLargeWaterPrice;
			 
		}

	// Method used to save string data using Java Output
	private void save(String filename, String data) {
		try {
			FileOutputStream fos = openFileOutput(filename,
					Context.MODE_PRIVATE);
			fos.write(data.getBytes());
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Method used to restore string data using Java Input
	private String load(String filename) {
		try {
			FileInputStream fis = openFileInput(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					fis));
			String line = null, input = "";
			while ((line = reader.readLine()) != null)
				input += line;
			reader.close();
			fis.close();
			return input;
		} catch (Exception ex) {

			return "";
		}
	}
	
	// Get all the item prices for the order
		private void getPrices() {
			try {
				String smallBurgerPriceString = Double.toString(smallBurgerPrice);
				smallBurgerPriceString = load("smallBurgerPrice06");
				smallBurgerPrice = Double.parseDouble(smallBurgerPriceString);
			} catch (Exception e) {
				
			}
			try {
				String regularBurgerPriceString = Double
						.toString(regularBurgerPrice);
				regularBurgerPriceString = load("regularBurgerPrice06");
				regularBurgerPrice = Double.parseDouble(regularBurgerPriceString);
			} catch (Exception e) {
				
			}
			try {
				String largeBurgerPriceString = Double.toString(largeBurgerPrice);
				largeBurgerPriceString = load("largeBurgerPrice06");
				largeBurgerPrice = Double.parseDouble(largeBurgerPriceString);
			} catch (Exception e) {
				
			}
			try {
				String extraLargeBurgerPriceString = Double
						.toString(extraLargeBurgerPrice);
				extraLargeBurgerPriceString = load("extraLargeBurgerPrice06");
				extraLargeBurgerPrice = Double
						.parseDouble(extraLargeBurgerPriceString);
			} catch (Exception e) {
				
			}
			try {
				String smallChickenBurgerPriceString = Double
						.toString(smallChickenBurgerPrice);
				smallChickenBurgerPriceString = load("smallChickenBurgerPrice06");
				smallChickenBurgerPrice = Double
						.parseDouble(smallChickenBurgerPriceString);
			} catch (Exception e) {
				
			}
			try {
				String regularChickenBurgerPriceString = Double
						.toString(regularChickenBurgerPrice);
				regularChickenBurgerPriceString = load("regularChickenBurgerPrice06");
				regularChickenBurgerPrice = Double
						.parseDouble(regularChickenBurgerPriceString);
			} catch (Exception e) {
				
			}
			try {
				String largeChickenBurgerPriceString = Double
						.toString(largeChickenBurgerPrice);
				largeChickenBurgerPriceString = load("largeChickenBurgerPrice06");
				largeChickenBurgerPrice = Double
						.parseDouble(largeChickenBurgerPriceString);
			} catch (Exception e) {
				
			}
			try {
				String extraLargeChickenBurgerPriceString = Double
						.toString(extraLargeChickenBurgerPrice);
				extraLargeChickenBurgerPriceString = load("extraLargeChickenBurgerPrice06");
				extraLargeChickenBurgerPrice = Double
						.parseDouble(extraLargeChickenBurgerPriceString);
			} catch (Exception e) {
				
			}
			try {
				String smallCokePriceString = Double.toString(smallCokePrice);
				smallCokePriceString = load("smallCokePrice06");
				smallCokePrice = Double.parseDouble(smallCokePriceString);
			} catch (Exception e) {
				
			}
			try {
				String regularCokePriceString = Double.toString(regularCokePrice);
				regularCokePriceString = load("regularCokePrice06");
				regularCokePrice = Double.parseDouble(regularCokePriceString);
			} catch (Exception e) {
				
			}
			try {
				String largeCokePriceString = Double.toString(largeCokePrice);
				largeCokePriceString = load("largeCokePrice06");
				largeCokePrice = Double.parseDouble(largeCokePriceString);
			} catch (Exception e) {
				
			}
			try {
				String extraLargeCokePriceString = Double
						.toString(extraLargeCokePrice);
				extraLargeCokePriceString = load("extraLargeCokePrice06");
				extraLargeCokePrice = Double.parseDouble(extraLargeCokePriceString);
			} catch (Exception e) {
				
			}
			try {
				String smallFantaPriceString = Double.toString(smallFantaPrice);
				smallFantaPriceString = load("smallFantaPrice06");
				smallFantaPrice = Double.parseDouble(smallFantaPriceString);
			} catch (Exception e) {
				
			}
			try {
				String regularFantaPriceString = Double.toString(regularFantaPrice);
				regularFantaPriceString = load("regularFantaPrice06");
				regularFantaPrice = Double.parseDouble(regularFantaPriceString);
			} catch (Exception e) {
				
			}
			try {
				String largeFantaPriceString = Double.toString(largeFantaPrice);
				largeFantaPriceString = load("largeFantaPrice06");
				largeFantaPrice = Double.parseDouble(largeFantaPriceString);
			} catch (Exception e) {
				
			}
			try {
				String extraLargeFantaPriceString = Double
						.toString(extraLargeFantaPrice);
				extraLargeFantaPriceString = load("extraLargeFantaPrice06");
				extraLargeFantaPrice = Double
						.parseDouble(extraLargeFantaPriceString);
			} catch (Exception e) {
				
			}
			try {
				String smallFishPriceString = Double.toString(smallFishPrice);
				smallFishPriceString = load("smallFishPrice06");
				smallFishPrice = Double.parseDouble(smallFishPriceString);
			} catch (Exception e) {
				
			}
			try {
				String regularFishPriceString = Double.toString(regularFishPrice);
				regularFishPriceString = load("regularFishPrice06");
				regularFishPrice = Double.parseDouble(regularFishPriceString);
			} catch (Exception e) {
				
			}
			try {
				String largeFishPriceString = Double.toString(largeFishPrice);
				largeFishPriceString = load("largeFishPrice06");
				largeFishPrice = Double.parseDouble(largeFishPriceString);
			} catch (Exception e) {
				
			}
			try {
				String extraLargeFishPriceString = Double
						.toString(extraLargeFishPrice);
				extraLargeFishPriceString = load("extraLargeFishPrice06");
				extraLargeFishPrice = Double.parseDouble(extraLargeFishPriceString);
			} catch (Exception e) {
				
			}
			try {
				String smallFriesPriceString = Double.toString(smallFriesPrice);
				smallFriesPriceString = load("smallFriesPrice06");
				smallFriesPrice = Double.parseDouble(smallFriesPriceString);
			} catch (Exception e) {
				
			}
			try {
				String regularFriesPriceString = Double.toString(regularFriesPrice);
				regularFriesPriceString = load("regularFriesPrice06");
				regularFriesPrice = Double.parseDouble(regularFriesPriceString);
			} catch (Exception e) {
				
			}
			try {
				String largeFriesPriceString = Double.toString(largeFriesPrice);
				largeFriesPriceString = load("largeFriesPrice06");
				largeFriesPrice = Double.parseDouble(largeFriesPriceString);
			} catch (Exception e) {
				
			}
			try {
				String extraLargeFriesPriceString = Double
						.toString(extraLargeFriesPrice);
				extraLargeFriesPriceString = load("extraLargeFriesPrice06");
				extraLargeFriesPrice = Double
						.parseDouble(extraLargeFriesPriceString);
			} catch (Exception e) {
				
			}
			try {
				String smallPizzaPriceString = Double.toString(smallPizzaPrice);
				smallPizzaPriceString = load("smallPizzaPrice06");
				smallPizzaPrice = Double.parseDouble(smallPizzaPriceString);
			} catch (Exception e) {
				
			}
			try {
				String regularPizzaPriceString = Double.toString(regularPizzaPrice);
				regularPizzaPriceString = load("regularPizzaPrice06");
				regularPizzaPrice = Double.parseDouble(regularPizzaPriceString);
			} catch (Exception e) {
			
			}
			try {
				String largePizzaPriceString = Double.toString(largePizzaPrice);
				largePizzaPriceString = load("largePizzaPrice06");
				largePizzaPrice = Double.parseDouble(largePizzaPriceString);
			} catch (Exception e) {
			
			}
			try {
				String extraLargePizzaPriceString = Double
						.toString(extraLargePizzaPrice);
				extraLargePizzaPriceString = load("extraLargePizzaPrice06");
				extraLargePizzaPrice = Double
						.parseDouble(extraLargePizzaPriceString);
			} catch (Exception e) {
				
			}
			try {
				String smallWaterPriceString = Double.toString(smallWaterPrice);
				smallWaterPriceString = load("smallWaterPrice06");
				smallWaterPrice = Double.parseDouble(smallWaterPriceString);
			} catch (Exception e) {
				
			}
			try {
				String regularWaterPriceString = Double.toString(regularWaterPrice);
				regularWaterPriceString = load("regularWaterPrice06");
				regularWaterPrice = Double.parseDouble(regularWaterPriceString);
			} catch (Exception e) {
				
			}
			try {
				String largeWaterPriceString = Double.toString(largeWaterPrice);
				largeWaterPriceString = load("largeWaterPrice06");
				largeWaterPrice = Double.parseDouble(largeWaterPriceString);
			} catch (Exception e) {
				
			}
			try {
				String extraLargeWaterPriceString = Double
						.toString(extraLargeWaterPrice);
				extraLargeWaterPriceString = load("extraLargeWaterPrice06");
				extraLargeWaterPrice = Double
						.parseDouble(extraLargeWaterPriceString);
			} catch (Exception e) {
			
			}

		}
	
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

	
	//This Method rounds the "Euro" values to 2 decimal places
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	// example of a computationally intensive action with UI updates
	// This method trys to slow down the progress bar as much as possible
	// by adding more work load for the processor
	private void do_work() {
		System.out.println("in do_work ()");
		Thread thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("Run () started...");
				computation(1);
				percent_done = 10;
				mHandler.post(mUpdateResults);
				System.out.println("Updated to 10%");

				computation(1);
				percent_done = 20;
				mHandler.post(mUpdateResults);
				System.out.println("Updated to 20%");

				computation(1);
				percent_done = 30;
				mHandler.post(mUpdateResults);
				System.out.println("Updated to 30%");

				computation(1);
				percent_done = 50;
				mHandler.post(mUpdateResults);
				System.out.println("Updated to 50%");

				computation(1);
				percent_done = 60;
				mHandler.post(mUpdateResults);
				System.out.println("Updated to 60%");

				computation(1);
				percent_done = 80;
				mHandler.post(mUpdateResults);
				System.out.println("Updated to 80%");

				computation(1);
				percent_done = 100;
				mHandler.post(mUpdateResults);
				System.out.println("Updated to 100%");

				System.out.println("Run () ended...");

			}
		});
		thread.start();

	}

	final static int SIZE = 200; // large enough to take some time kg lowered
									// was 1000
	double tmp;

	private void computation(int val) {
		for (int ii = 0; ii < SIZE; ii++)
			for (int jj = 0; jj < SIZE; jj++)
				tmp = val * Math.log(ii + 1) / Math.log1p(jj + 1);
	}
}

