package dao;

import java.net.UnknownHostException;

import models.Group;

import dao.BasicDAO;

import org.bson.types.ObjectId;

public class GroupDAO extends BasicDAO<Group, ObjectId> {
	public GroupDAO() throws NumberFormatException, UnknownHostException {
		super();
	}
}
