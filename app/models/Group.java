package models;

import java.util.Date;
import org.bson.types.ObjectId;

import play.data.validation.Constraints.Required;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity("groups")
public class Group {
	@Id
	public ObjectId id;
	@Required
	public String groupName;
	@play.data.format.Formats.DateTime(pattern = "yyyy-MM-dd")
	public Date date;

	public String toString() {
		return id + ":" + groupName;
	}
}
