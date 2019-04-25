package DemoProg.OfficeProj;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTest {

	public static void main(String[] args) throws JSONException {
		JSONObject obj = new JSONObject();
		JSONObject callLogEntry = new JSONObject();

		JSONObject user = new JSONObject();
		user.put("CountryCode", 123);
		JSONObject contryCode = new JSONObject();
		contryCode.put("ContryCode", user);

		JSONObject user2 = new JSONObject();
		user2.put("PhoneNumber", 456);
		JSONObject phoneNumber = new JSONObject();
		phoneNumber.put("Phone Number", user2);

		JSONObject user3 = new JSONObject();
		user3.put("name", 456);
		JSONObject name = new JSONObject();
		name.put("Name", user3);

		JSONArray notebookUsers = new JSONArray();
		notebookUsers.put(contryCode);
		notebookUsers.put(phoneNumber);
		notebookUsers.put(name);

		callLogEntry.put("CallLogEntry", notebookUsers);
		obj.put("CallLogEntry", notebookUsers);
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "Sample");
		obj1.put("age", new Integer(100));
		obj1.put("Add", "Sample");
		obj1.put("Other", new Integer(100));

		JSONObject obj2 = new JSONObject();
		obj2.put("name", "Sample");
		obj2.put("age", new Integer(100));
		obj2.put("Add", "Sample");
		obj2.put("Other", new Integer(100));
		JSONObject callLog = new JSONObject();

		callLog.put("One", obj);
		callLog.put("Two", obj1);
		callLog.put("Three", obj2);

		JSONObject callLogs = new JSONObject();
		callLogs.put("CallLog", callLog);
		System.out.println(callLogs.toString());
	}

}
