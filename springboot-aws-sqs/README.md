## Inorder to resolve below exception ::
org.springframework.beans.factory.BeanCreationException: 
Error creating bean with name 'org.springframework.cloud.aws.core.env.ResourceIdResolver.BEAN_NAME': Invocation of init method failed; 
nested exception is org.springframework.beans.factory.BeanCreationException: 
Error creating bean with name 'stackResourceRegistryFactoryBean' 
defined in class path resource [org/springframework/cloud/aws/autoconfigure/context/ContextStackAutoConfiguration.class]: 
Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: 
Failed to instantiate [org.springframework.cloud.aws.core.env.stack.config.StackResourceRegistryFactoryBean]: 
Factory method 'stackResourceRegistryFactoryBean' threw exception; nested exception is 
java.lang.IllegalArgumentException: No valid instance id defined