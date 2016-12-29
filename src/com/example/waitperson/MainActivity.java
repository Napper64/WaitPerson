package com.example.waitperson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import com.example.itemLists.ItemList01;
import com.example.itemLists.ItemList02;
import com.example.itemLists.ItemList03;
import com.example.itemLists.ItemList04;
import com.example.itemLists.ItemList05;
import com.example.itemLists.ItemList06;
import com.example.itemLists.ItemList07;
import com.example.itemLists.ItemList08;
import com.example.itemLists.ItemList09;
import com.example.itemLists.ItemList10;
import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	private String order01;
	private String order02;
	private String order03;
	private String order04;
	private String order05;
	private String order06;
	private String order07;
	private String order08;
	private String order09;
	private String order10;
	private NotificationManager mNManager;
	private static final int NOTIFY_ID1 = 1111;
	private static final int NOTIFY_ID2 = 2222;
	private static final int NOTIFY_ID3 = 3333;
	private static final int NOTIFY_ID4 = 4444;
	private static final int NOTIFY_ID5 = 5555;
	private static final int NOTIFY_ID6 = 6666;
	private static final int NOTIFY_ID7 = 7777;
	private static final int NOTIFY_ID8 = 8888;
	private static final int NOTIFY_ID9 = 9999;
	private static final int NOTIFY_ID10 = 1000;
	private static final String PREFERENCES = null;
	private Intent i;

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		String[] values = new String[] { "Table 1", "Table 2", "Table 3",
				"Table 4", "Table 5", "Table 6", "Table 7", "Table 8",
				"Table 9", "Table 10" };
		// use your custom layout
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);

		String ns = Context.NOTIFICATION_SERVICE; // toast shows "notification"

		mNManager = (NotificationManager) getSystemService(ns);
		final Notification msg = new Notification(R.drawable.order,
				"Orders Waiting", System.currentTimeMillis());

		try {
			order01 = load("order01");
			order02 = load("order02");
			order03 = load("order03");
			order04 = load("order04");
			order05 = load("order05");
			order06 = load("order06");
			order07 = load("order07");
			order08 = load("order08");
			order09 = load("order09");
			order10 = load("order10");
		} catch (Exception e) {

		}

		if (order01.equalsIgnoreCase("1")) {
			Context context = getApplicationContext();
			CharSequence contentTitle = "Table 1 has an order waiting";
			CharSequence contentText = "View Order";
			SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
			String Saved_Intent = settings.getString("Saved_Intent01", null);
			try {
				i = Intent.parseUri(Saved_Intent, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PendingIntent intent = PendingIntent.getActivity(MainActivity.this,
					0, i, Intent.FLAG_ACTIVITY_NEW_TASK);

			msg.defaults |= Notification.DEFAULT_SOUND;
			msg.flags |= Notification.FLAG_AUTO_CANCEL;
			msg.defaults |= Notification.DEFAULT_LIGHTS;
			msg.defaults |= Notification.DEFAULT_VIBRATE;

			msg.setLatestEventInfo(context, contentTitle, contentText, intent);
			mNManager.notify(NOTIFY_ID1, msg);
		}
		if (order02.equalsIgnoreCase("1")) {
			Context context = getApplicationContext();
			CharSequence contentTitle = "Table 2 has an order waiting";
			CharSequence contentText = "View Order";
			SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
			String Saved_Intent = settings.getString("Saved_Intent02", null);
			try {
				i = Intent.parseUri(Saved_Intent, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PendingIntent intent = PendingIntent.getActivity(MainActivity.this,
					0, i, Intent.FLAG_ACTIVITY_NEW_TASK);

			msg.defaults |= Notification.DEFAULT_SOUND;
			msg.flags |= Notification.FLAG_AUTO_CANCEL;
			msg.defaults |= Notification.DEFAULT_LIGHTS;
			msg.defaults |= Notification.DEFAULT_VIBRATE;

			msg.setLatestEventInfo(context, contentTitle, contentText, intent);
			mNManager.notify(NOTIFY_ID2, msg);
		}
		if (order03.equalsIgnoreCase("1")) {
			Context context = getApplicationContext();
			CharSequence contentTitle = "Table 3 has an order waiting";
			CharSequence contentText = "View Order";
			SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
			String Saved_Intent = settings.getString("Saved_Intent03", null);
			try {
				i = Intent.parseUri(Saved_Intent, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PendingIntent intent = PendingIntent.getActivity(MainActivity.this,
					0, i, Intent.FLAG_ACTIVITY_NEW_TASK);

			msg.defaults |= Notification.DEFAULT_SOUND;
			msg.flags |= Notification.FLAG_AUTO_CANCEL;
			msg.defaults |= Notification.DEFAULT_LIGHTS;
			msg.defaults |= Notification.DEFAULT_VIBRATE;

			msg.setLatestEventInfo(context, contentTitle, contentText, intent);
			mNManager.notify(NOTIFY_ID3, msg);
		}
		if (order04.equalsIgnoreCase("1")) {
			Context context = getApplicationContext();
			CharSequence contentTitle = "Table 4 has an order waiting";
			CharSequence contentText = "View Order";
			SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
			String Saved_Intent = settings.getString("Saved_Intent04", null);
			try {
				i = Intent.parseUri(Saved_Intent, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PendingIntent intent = PendingIntent.getActivity(MainActivity.this,
					0, i, Intent.FLAG_ACTIVITY_NEW_TASK);

			msg.defaults |= Notification.DEFAULT_SOUND;
			msg.flags |= Notification.FLAG_AUTO_CANCEL;
			msg.defaults |= Notification.DEFAULT_LIGHTS;
			msg.defaults |= Notification.DEFAULT_VIBRATE;

			msg.setLatestEventInfo(context, contentTitle, contentText, intent);
			mNManager.notify(NOTIFY_ID4, msg);
		}
		if (order05.equalsIgnoreCase("1")) {
			Context context = getApplicationContext();
			CharSequence contentTitle = "Table 5 has an order waiting";
			CharSequence contentText = "View Order";
			SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
			String Saved_Intent = settings.getString("Saved_Intent05", null);
			try {
				i = Intent.parseUri(Saved_Intent, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PendingIntent intent = PendingIntent.getActivity(MainActivity.this,
					0, i, Intent.FLAG_ACTIVITY_NEW_TASK);

			msg.defaults |= Notification.DEFAULT_SOUND;
			msg.flags |= Notification.FLAG_AUTO_CANCEL;
			msg.defaults |= Notification.DEFAULT_LIGHTS;
			msg.defaults |= Notification.DEFAULT_VIBRATE;

			msg.setLatestEventInfo(context, contentTitle, contentText, intent);
			mNManager.notify(NOTIFY_ID5, msg);
		}
		if (order06.equalsIgnoreCase("1")) {
			Context context = getApplicationContext();
			CharSequence contentTitle = "Table 6 has an order waiting";
			CharSequence contentText = "View Order";
			SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
			String Saved_Intent = settings.getString("Saved_Intent06", null);
			try {
				i = Intent.parseUri(Saved_Intent, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PendingIntent intent = PendingIntent.getActivity(MainActivity.this,
					0, i, Intent.FLAG_ACTIVITY_NEW_TASK);

			msg.defaults |= Notification.DEFAULT_SOUND;
			msg.flags |= Notification.FLAG_AUTO_CANCEL;
			msg.defaults |= Notification.DEFAULT_LIGHTS;
			msg.defaults |= Notification.DEFAULT_VIBRATE;

			msg.setLatestEventInfo(context, contentTitle, contentText, intent);
			mNManager.notify(NOTIFY_ID6, msg);
		}
		if (order07.equalsIgnoreCase("1")) {
			Context context = getApplicationContext();
			CharSequence contentTitle = "Table 7 has an order waiting";
			CharSequence contentText = "View Order";
			SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
			String Saved_Intent = settings.getString("Saved_Intent07", null);
			try {
				i = Intent.parseUri(Saved_Intent, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PendingIntent intent = PendingIntent.getActivity(MainActivity.this,
					0, i, Intent.FLAG_ACTIVITY_NEW_TASK);

			msg.defaults |= Notification.DEFAULT_SOUND;
			msg.flags |= Notification.FLAG_AUTO_CANCEL;
			msg.defaults |= Notification.DEFAULT_LIGHTS;
			msg.defaults |= Notification.DEFAULT_VIBRATE;

			msg.setLatestEventInfo(context, contentTitle, contentText, intent);
			mNManager.notify(NOTIFY_ID7, msg);
		}
		if (order08.equalsIgnoreCase("1")) {
			Context context = getApplicationContext();
			CharSequence contentTitle = "Table 8 has an order waiting";
			CharSequence contentText = "View Order";
			SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
			String Saved_Intent = settings.getString("Saved_Intent08", null);
			try {
				i = Intent.parseUri(Saved_Intent, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PendingIntent intent = PendingIntent.getActivity(MainActivity.this,
					0, i, Intent.FLAG_ACTIVITY_NEW_TASK);

			msg.defaults |= Notification.DEFAULT_SOUND;
			msg.flags |= Notification.FLAG_AUTO_CANCEL;
			msg.defaults |= Notification.DEFAULT_LIGHTS;
			msg.defaults |= Notification.DEFAULT_VIBRATE;

			msg.setLatestEventInfo(context, contentTitle, contentText, intent);
			mNManager.notify(NOTIFY_ID8, msg);
		}
		if (order09.equalsIgnoreCase("1")) {
			Context context = getApplicationContext();
			CharSequence contentTitle = "Table 9 has an order waiting";
			CharSequence contentText = "View Order";
			SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
			String Saved_Intent = settings.getString("Saved_Intent09", null);
			try {
				i = Intent.parseUri(Saved_Intent, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PendingIntent intent = PendingIntent.getActivity(MainActivity.this,
					0, i, Intent.FLAG_ACTIVITY_NEW_TASK);

			msg.defaults |= Notification.DEFAULT_SOUND;
			msg.flags |= Notification.FLAG_AUTO_CANCEL;
			msg.defaults |= Notification.DEFAULT_LIGHTS;
			msg.defaults |= Notification.DEFAULT_VIBRATE;

			msg.setLatestEventInfo(context, contentTitle, contentText, intent);
			mNManager.notify(NOTIFY_ID9, msg);
		}
		if (order10.equalsIgnoreCase("1")) {
			Context context = getApplicationContext();
			CharSequence contentTitle = "Table 10 has an order waiting";
			CharSequence contentText = "View Order";
			SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
			String Saved_Intent = settings.getString("Saved_Intent10", null);
			try {
				i = Intent.parseUri(Saved_Intent, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PendingIntent intent = PendingIntent.getActivity(MainActivity.this,
					0, i, Intent.FLAG_ACTIVITY_NEW_TASK);

			msg.defaults |= Notification.DEFAULT_SOUND;
			msg.flags |= Notification.FLAG_AUTO_CANCEL;
			msg.defaults |= Notification.DEFAULT_LIGHTS;
			msg.defaults |= Notification.DEFAULT_VIBRATE;

			msg.setLatestEventInfo(context, contentTitle, contentText, intent);
			mNManager.notify(NOTIFY_ID10, msg);
		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String table = (String) getListAdapter().getItem(position);
		if (table == "Table 1") {
			Intent intent = new Intent(this, ItemList01.class);
			intent.putExtra("tableNumber", table);
			startActivity(intent);
		} else if (table == "Table 2") {
			Intent intent = new Intent(this, ItemList02.class);
			intent.putExtra("tableNumber", table);
			startActivity(intent);
		} else if (table == "Table 3") {
			Intent intent = new Intent(this, ItemList03.class);
			intent.putExtra("tableNumber", table);
			startActivity(intent);
		} else if (table == "Table 4") {
			Intent intent = new Intent(this, ItemList04.class);
			intent.putExtra("tableNumber", table);
			startActivity(intent);
		} else if (table == "Table 5") {
			Intent intent = new Intent(this, ItemList05.class);
			intent.putExtra("tableNumber", table);
			startActivity(intent);
		} else if (table == "Table 6") {
			Intent intent = new Intent(this, ItemList06.class);
			intent.putExtra("tableNumber", table);
			startActivity(intent);
		} else if (table == "Table 7") {
			Intent intent = new Intent(this, ItemList07.class);
			intent.putExtra("tableNumber", table);
			startActivity(intent);
		} else if (table == "Table 8") {
			Intent intent = new Intent(this, ItemList08.class);
			intent.putExtra("tableNumber", table);
			startActivity(intent);
		} else if (table == "Table 9") {
			Intent intent = new Intent(this, ItemList09.class);
			intent.putExtra("tableNumber", table);
			startActivity(intent);
		} else if (table == "Table 10") {
			Intent intent = new Intent(this, ItemList10.class);
			intent.putExtra("tableNumber", table);
			startActivity(intent);
		}
	}

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

	private Boolean exit = false;

	@Override
	public void onBackPressed() {
		if (exit)
			MainActivity.this.finish();
		else {
			Toast.makeText(this, "Press Back again to Exit.",
					Toast.LENGTH_SHORT).show();
			exit = true;
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					exit = false;
				}
			}, 3 * 1000);

		}

	}
}
