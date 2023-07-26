package my;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author YMSLX
 * @version 1.0
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/appContext.xml")
public class VelocitoySpringAnnotationTest {

	@Autowired
	private VelocityEngine ve;


	@Test
	public void test_render_string() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("foo", "world");
		String templateText = "Hi-${foo}!";
		String out = renderStringTemplate(ve, templateText, vars);
		log.info("String render, result:{}.", out);
		assertEquals("Hi-world!", out);
	}

	@Test
	public void test_render_string_math() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("number", 20);
		String templateText = "#set($percent = $number / (100 * 0.1)) \n$percent";
		String out = renderStringTemplate(ve, templateText, vars);
		log.info("String render - math, result:{}.", out);
		assertEquals("2.0", out);
	}

	@Test
	public void test_render_with_template_file() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("foo", "world");
		String out = renderTemplateFile("hello.vm", vars);
		log.info("String render, result:{}.", out);
		assertEquals("Hi-world!", out);
	}

	@Test
	public void test_render_with_template_iter_file() {
		String out = renderTemplateFile("iter.vm");
		log.info("String render, result:{}.", out);
		assertEquals(" 0 1 2 3 4 5 6 7 8 9 10", out);
	}

	@Test
	public void test_render_with_template_foreach_file() {
		String out = renderTemplateFile("foreach.vm");
		log.info("String render, result:{}.", out);
		assertThat(out, notNullValue());
	}
	
	@Test
	public void test_render_with_template_if_file() {
		String out = renderTemplateFile("if.vm");
		log.info("String render, result:{}.", out);
		assertThat(out, notNullValue());
	}


	private String renderTemplateFile(String templateFile) {
		return renderTemplateFile(templateFile, null);
	}

	private String renderTemplateFile(String templateFile, Map<String, Object> vars) {
		return VelocityEngineUtils.mergeTemplateIntoString(ve, templateFile, StandardCharsets.UTF_8.name(), vars);
	}

	private String renderStringTemplate(VelocityEngine ve, String stringTemplate, Map<String, Object> vars) {
		VelocityContext vc = new VelocityContext(vars);
		StringWriter sw = new StringWriter();
		ve.evaluate(vc, sw, "Render string", stringTemplate);
		return sw.toString();
	}

}
