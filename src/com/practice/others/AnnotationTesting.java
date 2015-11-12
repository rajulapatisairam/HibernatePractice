package com.practice.others;

import java.lang.reflect.Field;

/**
 * @author Sairam Rajulapati
 */
public class AnnotationTesting {
	public static void main(String[] args) {
		AnnotationTesting testing = new AnnotationTesting();
		Pojo pojo = new Pojo();
		System.out.println("\n\t\t\t\t\tB4 Processing Pojo CLass");
		displayPojoClassData(pojo);
		testing.setDataToPojoClass(pojo);
		System.out.println("\t\t\t\t\tAfter Processing Pojo CLass");
		displayPojoClassData(pojo);
	}

	private static void displayPojoClassData(Pojo pojo) {
		System.out.println(" Column 1 is : "+pojo.getColumn1()+"\n Column 2 is : "+pojo.getColumn2()+"\n Column 3 is : "+pojo.getColumn3());
	}

	private void setDataToPojoClass(Object object) {
		// Get the Object class.
		Class<?> class1 = object.getClass();
		
		// Get the list of declared Object class fields, irrespective of access specifies (i.e: private, public) 
		Field[] fields = class1.getDeclaredFields();
		try {
		// Iterator through fields collection.	
		for(Field field : fields){
			
			// Set field Accessible to true for access private fields too.
			field.setAccessible(true);
		   /**
		    * Check current indexing field, weather it's having @MyAnnotation annotation or not.
		    */
			if(field.isAnnotationPresent(MyAnnotation.class)){
				// Get the MyAnnotation Object from current indexing field.
				MyAnnotation annotation =  field.getAnnotation(MyAnnotation.class);
				// Set Annotation specified data to Object class local field.
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
