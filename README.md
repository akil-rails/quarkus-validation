# Intro

Running tests with `quarkus dev` does not show the `ConstraintValidation Exception` when the `@Valid` annotation is used; instead the following is shown:

```
2023-05-27 22:10:01,137 ERROR [io.qua.test] (Test runner thread) Internal error running tests: java.lang.RuntimeException: java.lang.RuntimeException: com.fasterxml.jackson.databind.JsonMappingException: HV000116: getParameterIndex() may only be invoked for nodes of type ElementKind.PARAMETER. (through reference chain: io.quarkus.deployment.dev.testing.TestRunResults["results"]->java.util.Collections$UnmodifiableMap["org.acme.ClientTest"]->io.quarkus.deployment.dev.testing.TestClassResult["failing"]->java.util.ArrayList[0]->io.quarkus.deployment.dev.testing.TestResult["problems"]->java.util.Collections$UnmodifiableRandomAccessList[0]->io.quarkus.hibernate.validator.runtime.jaxrs.ResteasyReactiveViolationException["constraintViolations"]->java.util.HashSet[0]->org.hibernate.validator.internal.engine.ConstraintViolationImpl["propertyPath"]->org.hibernate.validator.internal.engine.path.PathImpl["leafNode"]->org.hibernate.validator.internal.engine.path.NodeImpl["parent"]->org.hibernate.validator.internal.engine.path.NodeImpl["parent"]->org.hibernate.validator.internal.engine.path.NodeImpl["parent"]->org.hibernate.validator.internal.engine.path.NodeImpl["parameterIndex"])
	at io.quarkus.devui.runtime.continuoustesting.ContinuousTestingJsonRPCService.invokeAction(ContinuousTestingJsonRPCService.java:96)
	at io.quarkus.devui.runtime.continuoustesting.ContinuousTestingJsonRPCService.getResults(ContinuousTestingJsonRPCService.java:89)
	at io.quarkus.devui.runtime.continuoustesting.ContinuousTestingJsonRPCService.accept(ContinuousTestingJsonRPCService.java:39)
	at io.quarkus.devui.runtime.continuoustesting.ContinuousTestingJsonRPCService.accept(ContinuousTestingJsonRPCService.java:15)
	at io.quarkus.devui.runtime.continuoustesting.ContinuousTestingJsonRPCService_ClientProxy.accept(Unknown Source)
	at io.quarkus.dev.testing.ContinuousTestingSharedStateManager.setLastState(ContinuousTestingSharedStateManager.java:36)
	at io.quarkus.dev.testing.ContinuousTestingSharedStateManager.setInProgress(ContinuousTestingSharedStateManager.java:45)
	at io.quarkus.deployment.dev.testing.ContinuousTestingSharedStateListener.testRunStarted(ContinuousTestingSharedStateListener.java:48)
	at io.quarkus.deployment.dev.testing.TestSupport.runInternal(TestSupport.java:416)
	at io.quarkus.deployment.dev.testing.TestSupport$3.run(TestSupport.java:381)
	at java.base/java.lang.Thread.run(Thread.java:833)
Caused by: java.lang.RuntimeException: com.fasterxml.jackson.databind.JsonMappingException: HV000116: getParameterIndex() may only be invoked for nodes of type ElementKind.PARAMETER. (through reference chain: io.quarkus.deployment.dev.testing.TestRunResults["results"]->java.util.Collections$UnmodifiableMap["org.acme.ClientTest"]->io.quarkus.deployment.dev.testing.TestClassResult["failing"]->java.util.ArrayList[0]->io.quarkus.deployment.dev.testing.TestResult["problems"]->java.util.Collections$UnmodifiableRandomAccessList[0]->io.quarkus.hibernate.validator.runtime.jaxrs.ResteasyReactiveViolationException["constraintViolations"]->java.util.HashSet[0]->org.hibernate.validator.internal.engine.ConstraintViolationImpl["propertyPath"]->org.hibernate.validator.internal.engine.path.PathImpl["leafNode"]->org.hibernate.validator.internal.engine.path.NodeImpl["parent"]->org.hibernate.validator.internal.engine.path.NodeImpl["parent"]->org.hibernate.validator.internal.engine.path.NodeImpl["parent"]->org.hibernate.validator.internal.engine.path.NodeImpl["parameterIndex"])
	at io.quarkus.devui.deployment.menu.ContinuousTestingProcessor.lambda$registerGetResultsMethod$5(ContinuousTestingProcessor.java:198)
	at io.quarkus.dev.console.DevConsoleManager.invoke(DevConsoleManager.java:135)
	at io.quarkus.devui.runtime.continuoustesting.ContinuousTestingJsonRPCService.invokeAction(ContinuousTestingJsonRPCService.java:94)
	... 10 more
Caused by: com.fasterxml.jackson.databind.JsonMappingException: HV000116: getParameterIndex() may only be invoked for nodes of type ElementKind.PARAMETER. (through reference chain: io.quarkus.deployment.dev.testing.TestRunResults["results"]->java.util.Collections$UnmodifiableMap["org.acme.ClientTest"]->io.quarkus.deployment.dev.testing.TestClassResult["failing"]->java.util.ArrayList[0]->io.quarkus.deployment.dev.testing.TestResult["problems"]->java.util.Collections$UnmodifiableRandomAccessList[0]->io.quarkus.hibernate.validator.runtime.jaxrs.ResteasyReactiveViolationException["constraintViolations"]->java.util.HashSet[0]->org.hibernate.validator.internal.engine.ConstraintViolationImpl["propertyPath"]->org.hibernate.validator.internal.engine.path.PathImpl["leafNode"]->org.hibernate.validator.internal.engine.path.NodeImpl["parent"]->org.hibernate.validator.internal.engine.path.NodeImpl["parent"]->org.hibernate.validator.internal.engine.path.NodeImpl["parent"]->org.hibernate.validator.internal.engine.path.NodeImpl["parameterIndex"])
	at com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(JsonMappingException.java:402)
	at com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(JsonMappingException.java:361)
	at com.fasterxml.jackson.databind.ser.std.StdSerializer.wrapAndThrow(StdSerializer.java:316)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:782)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:733)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:774)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:733)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:774)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:733)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:774)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:733)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:774)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:733)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:774)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
	at com.fasterxml.jackson.databind.ser.std.CollectionSerializer.serializeContents(CollectionSerializer.java:145)
	at com.fasterxml.jackson.databind.ser.std.CollectionSerializer.serialize(CollectionSerializer.java:107)
	at com.fasterxml.jackson.databind.ser.std.CollectionSerializer.serialize(CollectionSerializer.java:25)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:733)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:774)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
	at com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer.serializeContents(IndexedListSerializer.java:119)
	at com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer.serialize(IndexedListSerializer.java:79)
	at com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer.serialize(IndexedListSerializer.java:18)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:733)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBa:774)va
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
	at com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer.serializeContents(IndexedListSerializer.java:119)
	at com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer.serialize(IndexedListSerializer.java:79)
	at com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer.serialize(IndexedListSerializer.java:18)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:733)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:774)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
	at com.fasterxml.jackson.databind.ser.std.MapSerializer.serializeFields(MapSerializer.java:808)
	at com.fasterxml.jackson.databind.ser.std.MapSerializer.serializeWithoutTypeInfo(MapSerializer.java:764)
	at com.fasterxml.jackson.databind.ser.std.MapSerializer.serialize(MapSerializer.java:720)
	at com.fasterxml.jackson.databind.ser.std.MapSerializer.serialize(MapSerializer.java:35)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:733)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:774)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:480)
	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:319)
	at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4624)
	at com.fasterxml.jackson.databind.ObjectMapper.writeValue(ObjectMapper.java:3852)
	at io.quarkus.devui.deployment.menu.ContinuousTestingProcessor.lambda$registerGetResultsMethod$5(ContinuousTestingProcessor.java:193)
	... 12 more
Caused by: java.lang.IllegalArgumentException: HV000116: getParameterIndex() may only be invoked for nodes of type ElementKind.PARAMETER.
	at org.hibernate.validator.internal.util.Contracts.assertTrue(Contracts.java:66)
	at org.hibernate.validator.internal.engine.path.NodeImpl.getParameterIndex(NodeImpl.java:366)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:689)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:774)
	... 58 more

```

Running tests with `quarkus test`, reports the `Constraint Violation` as expected:

```
2023-05-27 22:12:02,265 ERROR [io.qua.test] (Test runner thread) ==================== TEST REPORT #1 ==================== [Error Occurred After Shutdown]
2023-05-27 22:12:02,266 ERROR [io.qua.test] (Test runner thread) Test ClientTest#test2() failed 
 [Error Occurred After Shutdown]: io.quarkus.hibernate.validator.runtime.jaxrs.ResteasyReactiveViolationException: post.request.body: must not be blank
	at io.quarkus.hibernate.validator.runtime.jaxrs.ResteasyReactiveEndPointValidationInterceptor.validateMethodInvocation(ResteasyReactiveEndPointValidationInterceptor.java:23)
	at io.quarkus.hibernate.validator.runtime.jaxrs.ResteasyReactiveEndPointValidationInterceptor_Bean.intercept(Unknown Source)
	at io.quarkus.arc.impl.InterceptorInvocation.invoke(InterceptorInvocation.java:42)
	at io.quarkus.arc.impl.AroundInvokeInvocationContext.perform(AroundInvokeInvocationContext.java:38)
	at io.quarkus.arc.impl.InvocationContexts.performAroundInvoke(InvocationContexts.java:26)
	at org.acme.Client$$CDIWrapper_Subclass.post(Unknown Source)
	at org.acme.Client$$CDIWrapper_ClientProxy.post(Unknown Source)
	at org.acme.ClientTest.test2(ClientTest.java:29)


2023-05-27 22:12:02,269 ERROR [io.qua.test] (Test runner thread) >>>>>>>>>>>>>>>>>>>> Summary: <<<<<<<<<<<<<<<<<<<<
org.acme.ClientTest#test2(ClientTest.java:29) ClientTest#test2() post.request.body: must not be blank [Error Occurred After Shutdown]
2023-05-27 22:12:02,272 ERROR [io.qua.test] (Test runner thread) >>>>>>>>>>>>>>>>>>>> 1 TEST FAILED <<<<<<<<<<<<<<<<<<<< [Error Occurred After Shutdown]

```