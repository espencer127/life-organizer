package com.spencer.checklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.StringUtils;

public class ExecutionsUtil {
	
	public static List<String> toList(String executions) {
		String[] strArr = StringUtils.commaDelimitedListToStringArray(executions);
		List<String> resp = new ArrayList<>();
		if (strArr != null && strArr.length != 0) {
			resp.addAll(Arrays.asList(strArr));
		}
		
		return resp;
	}
	
	public static String fromList(List<String> executionsList) {
		return StringUtils.collectionToCommaDelimitedString(executionsList);
	}
	
	public static List<String> fromString(String executions) {
		return toList(executions);
	}
	
	public static String toString(List<String> executionsList) {
		return fromList(executionsList);
	}

}
