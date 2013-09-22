package controllers;

import java.net.UnknownHostException;

import org.bson.types.ObjectId;

import dao.GroupDAO;
import models.Group;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
	static Form<Group> groupForm = form(Group.class);
	
	private static GroupDAO getGroupDao(){
		try {
			return new GroupDAO();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Result index() throws Exception {
		// redirect to the "group Result
		return redirect(routes.Application.group());
	}

	public static Result group()  {
		return ok(views.html.index.render(getGroupDao().find().asList(), groupForm));
	}

	public static Result newGroup() {
		Form<Group> filledForm = groupForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return badRequest(views.html.index.render(getGroupDao().find().asList(), filledForm));
		} else {
			getGroupDao().save(filledForm.get());
			return redirect(routes.Application.group());  
		}
	}
	
	public static Result deleteGroup(String id) {
		getGroupDao().deleteById(new ObjectId(id));
		return redirect(routes.Application.group());
	}
}