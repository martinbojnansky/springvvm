package com.bojnansky.springvvm.framework;

import java.io.IOException;
import java.util.List;

public interface Generator {
	void run(List<String> javaPackageNames) throws IOException;
}
