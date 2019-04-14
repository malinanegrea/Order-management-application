package Presentation;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ReflectionTable {

	@SuppressWarnings("unchecked")
	private static void getHeader(Object obj, DefaultTableModel model) {

		@SuppressWarnings("rawtypes")
		Vector row = new Vector();
		for (Field field : obj.getClass().getDeclaredFields()) {
			model.addColumn(field.getName());
			row.add(field.getName());
		}
		model.addRow(row);
	}

	@SuppressWarnings("unchecked")
	public static void addRow(Object obj, DefaultTableModel model) {
		@SuppressWarnings("rawtypes")
		Vector row = new Vector();
		for (Field field : obj.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				row.add(field.get(obj));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addRow(row);
	}

	public static void setTabel(List<? extends Object> obj, DefaultTableModel model) {

		getHeader(obj.get(0), model);

		for (Object o : obj) {
			addRow(o, model);
		}
	}

}
