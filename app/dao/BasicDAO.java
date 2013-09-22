package dao;

import java.net.UnknownHostException;

import play.Play;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;


public class BasicDAO<T, K> extends com.google.code.morphia.dao.BasicDAO<T, K> {
	public BasicDAO() throws NumberFormatException, UnknownHostException {
		super(new Mongo(Play.application().configuration().getString("storage.api.default.url"), 
			       Integer.valueOf(Play.application().configuration().getString("storage.api.default.port"))), 
		  new Morphia(), Play.application().configuration().getString("storage.api.default.db"));
	}
}
