package fr.treeptik.model;

import org.springframework.core.io.Resource;

public class ResourceInjected {

	Resource resource;

	public ResourceInjected() {
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public String toString() {
		return "ResourceInjected [resource=" + resource + "]";
	}

}
