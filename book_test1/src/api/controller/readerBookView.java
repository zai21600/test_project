package api.controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import connection.ConnectionUtils;
import connection.MySQLConnUtils;

import api.model.Book;

@Path("/BookView/reader")
public class readerBookView {
	
	@GET
	public Response getReaderTable() throws SQLException, NamingException, ClassNotFoundException   {
		
		Connection db = MySQLConnUtils.getMySQLConnection();
		try {
			JsonArrayBuilder jsonArray =Json.createArrayBuilder();
			PreparedStatement st = db.prepareStatement(
					"Select a.book_name, a.author, a.chapter, a.content from book a"
					);
			ResultSet rs = st.executeQuery();
			List<Book> book = new ArrayList<Book>();
			System.out.println("Database connected");
			while (rs.next()) {
		        //data.add(new Classes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)));
		        jsonArray.add((javax.json.JsonValue) Json.createObjectBuilder().add("book_name", rs.getString(1))
		        													.add("author", rs.getString(2))
		        													.add("chapter", rs.getString(3))
		        													.add("content", rs.getString(4))
		        													.build());
		        }
			JsonArray retArray = jsonArray.build();
		return Response.ok().entity(retArray.toString()).build();
		}
		finally {
			db.close();
		}
	}
}