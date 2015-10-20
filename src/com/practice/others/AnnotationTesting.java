package com.practice.others;

import java.lang.reflect.Field;

public class AnnotationTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationTesting AnnotationTesting_obj = new AnnotationTesting();
		Pojo pojo = new Pojo();
		displayPojoClassData(pojo);
		AnnotationTesting_obj.setDataToPojoClass(pojo);		
		displayPojoClassData(pojo);
	}

	private static void displayPojoClassData(Pojo pojo) {
		System.out.println(" Column 1 is : "+pojo.getColumn1()+"\n Column 2 is: "+pojo.getColumn2()+"\n Column 3 is : "+pojo.getColumn3());
	}

	private void setDataToPojoClass(Object object) {
		Class<?> class1 = object.getClass();
		Field[] fields = class1.getDeclaredFields();
		try {
		for(Field field : fields){
			field.setAccessible(true);
			if(field.isAnnotationPresent(MyAnnotation.class)){
				MyAnnotation annotation =  field.getAnnotation(MyAnnotation.class);
				Class dataType  = field.getType();
				
				//System.out.println(" Field Name is  : "+annotation.columName());
				field.set(object, annotation.columName());
			}
		 }
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
