package org.fhict.contactreader;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;

public class TodoLoaderTask extends AsyncTask<Void, Void, List<String>> {
	private OnContactsLoadedListener listener;
	private ContentResolver contentResolver;

	public TodoLoaderTask(OnContactsLoadedListener listener,
			ContentResolver contentResolver)	{
		this.listener = listener;
		this.contentResolver = contentResolver;
	}

	@Override
	protected List<String> doInBackground(Void... arg0) {
		List<String> todos = new ArrayList<String>();

		//todos.add("Not empty...");
		//new:
		Uri uri = Uri.parse("content://de.vogella.android.todos.contentprovider/todos");
		
		String[] projection = new String[] {
				
				"description",
				"summary"
				
				//ContactsContract.Contacts.DISPLAY_NAME,
		};
		
		
		
		String selection = null;
		String[] selectionArgs = null;
		String sortOrder = "category";

		Cursor cursor = contentResolver.query(uri, projection, 
							      selection, selectionArgs, sortOrder);

		if(cursor.moveToFirst()) {
			while(!cursor.isAfterLast()) {

				int nameColumnId = cursor.getColumnIndex(projection[0]);
			//	int nameColumnId2 = cursor.getColumnIndex(projection[1]);
				String description = cursor.getString(nameColumnId);
				//String summary = cursor.getString(nameColumnId2);
				todos.add(description);

				cursor.moveToNext();
			}
		}
		//end
				

		return todos;
	}

	@Override
	protected void onPostExecute(List<String> todos) {
		listener.onLoaded(todos);
	}
}

