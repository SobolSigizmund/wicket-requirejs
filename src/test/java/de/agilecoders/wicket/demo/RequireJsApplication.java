package de.agilecoders.wicket.demo;

import de.agilecoders.wicket.requirejs.RequireJs;
import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 *
 */
public class RequireJsApplication extends WebApplication
{
	@Override
	public Class<? extends Page> getHomePage()
	{
		return HomePage.class;
	}

	@Override
	protected void init()
	{
		super.init();

		mountPage("some/very/deep/path", PageB.class);
		mountPage("c", PageC.class);

		RequireJs.install(this);

		getResourceBundles().addJavaScriptBundle(RequireJsApplication.class, "bundle.js",
			new JavaScriptResourceReference(HomePage.class, "demo1.js"),
			new JavaScriptResourceReference(PageB.class, "pageB.js")
		);
	}

	@Override
	public RuntimeConfigurationType getConfigurationType()
	{
		return RuntimeConfigurationType.DEVELOPMENT;
	}
}
