package com.fedex.validator.queryhandler;

public interface IQueryHandler {

	int insert(String query);

	int update(String query);

	int delete(String query);

	Object select(String query);

}
