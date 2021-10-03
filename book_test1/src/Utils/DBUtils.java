package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.model.Book;

public class DBUtils {
	public static List<Book> queryBook(Connection conn) throws SQLException {
		String sql = "Select a.book_name, a.author, a.chapter, a.content from book a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Book> list = new ArrayList<Book>();
		while (rs.next()) {
			String book_name = rs.getString("BOOK_NAME");
			String author = rs.getString("AUTHOR");
			String chapter = rs.getString("CHAPTER");
			String content = rs.getString("CONTENT");
			
			Book book = new Book();
			book.setName(book_name);
			book.setAuthor(author);
			book.setChapter(chapter);
			book.setContent(content);
			list.add(book);
		}
		return list;
	}
}
