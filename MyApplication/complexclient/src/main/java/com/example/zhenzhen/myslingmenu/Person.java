/**
 *
 */
package com.example.zhenzhen.myslingmenu;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class Person implements Parcelable
{
	private Integer id;
	private String name;
	private String pass;

	public Person()
	{
	}
	public Person(Integer id, String name, String pass)
	{
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPass()
	{
		return pass;
	}
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		if (pass == null)
		{
			if (other.pass != null)
				return false;
		}
		else if (!pass.equals(other.pass))
			return false;
		return true;
	}
	// ʵ��Parcelable�ӿڱ���ʵ�ֵķ���
	@Override
	public int describeContents()
	{
		return 0;
	}
	// ʵ��Parcelable�ӿڱ���ʵ�ֵķ���
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		//�Ѹö���������������д��Parcel
		dest.writeInt(id);
		dest.writeString(name);
		dest.writeString(pass);
	}

	// ���һ����̬��Ա,��ΪCREATOR,�ö���ʵ����Parcelable.Creator�ӿ�
	public static final Creator<Person> CREATOR
		= new Creator<Person>() //��
	{
		@Override
		public Person createFromParcel(Parcel source)
		{
			// ��Parcel�ж�ȡ���ݣ�����Person����
			return new Person(source.readInt()
				, source.readString()
				, source.readString());
		}

		@Override
		public Person[] newArray(int size)
		{
			return new Person[size];
		}
	};
}
