// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package testsuite.proxies;

public class Progress
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject progressMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "TestSuite.Progress";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Progress("Progress"),
		MaximumValue("MaximumValue"),
		Progress_2("Progress_2"),
		Progress_3("Progress_3"),
		displayText("displayText");

		private java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@java.lang.Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public Progress(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "TestSuite.Progress"));
	}

	protected Progress(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject progressMendixObject)
	{
		if (progressMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("TestSuite.Progress", progressMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a TestSuite.Progress");

		this.progressMendixObject = progressMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'Progress.load(IContext, IMendixIdentifier)' instead.
	 */
	@java.lang.Deprecated
	public static testsuite.proxies.Progress initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return testsuite.proxies.Progress.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static testsuite.proxies.Progress initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new testsuite.proxies.Progress(context, mendixObject);
	}

	public static testsuite.proxies.Progress load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return testsuite.proxies.Progress.initialize(context, mendixObject);
	}

	public static java.util.List<testsuite.proxies.Progress> load(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String xpathConstraint) throws com.mendix.core.CoreException
	{
		java.util.List<testsuite.proxies.Progress> result = new java.util.ArrayList<testsuite.proxies.Progress>();
		for (com.mendix.systemwideinterfaces.core.IMendixObject obj : com.mendix.core.Core.retrieveXPathQuery(context, "//TestSuite.Progress" + xpathConstraint))
			result.add(testsuite.proxies.Progress.initialize(context, obj));
		return result;
	}

	/**
	 * Commit the changes made on this proxy object.
	 */
	public final void commit() throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 */
	public final void commit(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(com.mendix.systemwideinterfaces.core.IContext context)
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}
	/**
	 * @return value of Progress
	 */
	public final java.lang.Integer getProgress()
	{
		return getProgress(getContext());
	}

	/**
	 * @param context
	 * @return value of Progress
	 */
	public final java.lang.Integer getProgress(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Integer) getMendixObject().getValue(context, MemberNames.Progress.toString());
	}

	/**
	 * Set value of Progress
	 * @param progress
	 */
	public final void setProgress(java.lang.Integer progress)
	{
		setProgress(getContext(), progress);
	}

	/**
	 * Set value of Progress
	 * @param context
	 * @param progress
	 */
	public final void setProgress(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Integer progress)
	{
		getMendixObject().setValue(context, MemberNames.Progress.toString(), progress);
	}

	/**
	 * @return value of MaximumValue
	 */
	public final java.lang.Integer getMaximumValue()
	{
		return getMaximumValue(getContext());
	}

	/**
	 * @param context
	 * @return value of MaximumValue
	 */
	public final java.lang.Integer getMaximumValue(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Integer) getMendixObject().getValue(context, MemberNames.MaximumValue.toString());
	}

	/**
	 * Set value of MaximumValue
	 * @param maximumvalue
	 */
	public final void setMaximumValue(java.lang.Integer maximumvalue)
	{
		setMaximumValue(getContext(), maximumvalue);
	}

	/**
	 * Set value of MaximumValue
	 * @param context
	 * @param maximumvalue
	 */
	public final void setMaximumValue(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Integer maximumvalue)
	{
		getMendixObject().setValue(context, MemberNames.MaximumValue.toString(), maximumvalue);
	}

	/**
	 * @return value of Progress_2
	 */
	public final java.math.BigDecimal getProgress_2()
	{
		return getProgress_2(getContext());
	}

	/**
	 * @param context
	 * @return value of Progress_2
	 */
	public final java.math.BigDecimal getProgress_2(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.math.BigDecimal) getMendixObject().getValue(context, MemberNames.Progress_2.toString());
	}

	/**
	 * Set value of Progress_2
	 * @param progress_2
	 */
	public final void setProgress_2(java.math.BigDecimal progress_2)
	{
		setProgress_2(getContext(), progress_2);
	}

	/**
	 * Set value of Progress_2
	 * @param context
	 * @param progress_2
	 */
	public final void setProgress_2(com.mendix.systemwideinterfaces.core.IContext context, java.math.BigDecimal progress_2)
	{
		getMendixObject().setValue(context, MemberNames.Progress_2.toString(), progress_2);
	}

	/**
	 * @return value of Progress_3
	 */
	public final java.lang.Long getProgress_3()
	{
		return getProgress_3(getContext());
	}

	/**
	 * @param context
	 * @return value of Progress_3
	 */
	public final java.lang.Long getProgress_3(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Long) getMendixObject().getValue(context, MemberNames.Progress_3.toString());
	}

	/**
	 * Set value of Progress_3
	 * @param progress_3
	 */
	public final void setProgress_3(java.lang.Long progress_3)
	{
		setProgress_3(getContext(), progress_3);
	}

	/**
	 * Set value of Progress_3
	 * @param context
	 * @param progress_3
	 */
	public final void setProgress_3(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Long progress_3)
	{
		getMendixObject().setValue(context, MemberNames.Progress_3.toString(), progress_3);
	}

	/**
	 * @return value of displayText
	 */
	public final java.lang.String getdisplayText()
	{
		return getdisplayText(getContext());
	}

	/**
	 * @param context
	 * @return value of displayText
	 */
	public final java.lang.String getdisplayText(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.displayText.toString());
	}

	/**
	 * Set value of displayText
	 * @param displaytext
	 */
	public final void setdisplayText(java.lang.String displaytext)
	{
		setdisplayText(getContext(), displaytext);
	}

	/**
	 * Set value of displayText
	 * @param context
	 * @param displaytext
	 */
	public final void setdisplayText(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String displaytext)
	{
		getMendixObject().setValue(context, MemberNames.displayText.toString(), displaytext);
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return progressMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final testsuite.proxies.Progress that = (testsuite.proxies.Progress) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@java.lang.Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static java.lang.String getType()
	{
		return "TestSuite.Progress";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@java.lang.Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}