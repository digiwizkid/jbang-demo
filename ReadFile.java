///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS com.google.code.gson:gson:2.8.9

import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.google.gson.Gson;

public class ReadFile {

    public static void main(String... args) {
	    if(args.length > 0) {
			try {
				String jsonString = "";
				File file = new File(args[0]);
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				while((line = br.readLine()) != null) {
					jsonString+=line;
					out.println(line);
				}
				br.close();

				out.println("\nGSON");

				Gson gson = new Gson();

				User user = gson.fromJson(jsonString, User.class);

				out.println(user);

			} catch(Exception e) {
			}
	    } else
			out.println("Hello, World!");
    }

	class User {
		String name;
		String username;
		String email;

		public User(){}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUsername() {
			return this.username;
		}

		public void setUsername(String username) {
			this.name = username;
		}

		public String getEmail() {
			return this.email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return name+" "+username+" "+email;
		}
	} 
}