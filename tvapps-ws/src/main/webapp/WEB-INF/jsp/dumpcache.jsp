<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>Dump Cache</title>
</head>

<body>
	<h1>Statics start Time: ${start}</h1>
	<h2>Data base Connection Global Info:</h2>
	<h4>
		Connection Count=
		<c:out value="${cacheform.connectCount}" />
		&nbsp;:&nbsp;Transaction Count=
		<c:out value="${cacheform.transactionCount}" />
		&nbsp;:&nbsp;Successful Transaction Count=
		<c:out value="${cacheform.successfulTransactionCount}" />
		&nbsp;:&nbsp;Session Open=
		<c:out value="${cacheform.sessionOpenCount}" />
		&nbsp;:&nbsp;Session Close=
		<c:out value="${cacheform.sessionCloseCount}" />
		<p />
		Prepare Statement Count=
		<c:out value="${cacheform.prepareStatementCount}" />
		&nbsp;:&nbsp;Close Statement Count=
		<c:out value="${cacheform.closeStatementCount}" />
		&nbsp;:&nbsp;Flush Count=
		<c:out value="${cacheform.flushCount}" />
	</h4>
	<h2>Second Level Cache global Info:</h2>
	<h4>
		Put Count=
		<c:out value="${cacheform.secondLevelCachePutCount}" />
		&nbsp;:&nbsp;Hit Count=
		<c:out value="${cacheform.secondLevelCacheHitCount}" />
		&nbsp;:&nbsp;Miss Count=
		<c:out value="${cacheform.secondLevelCacheMissCount}" />
	</h4>
	<table border="1">
		<tr>
			<td>Category Name</td>
			<td>In Memory Cnt</td>
			<td>On Disk Cnt</td>
			<td>Put Acount</td>
			<td>Hit Cnt</td>
			<td>Miss Cnt</td>
			<td>Size</td>
		</tr>
		<c:forEach items="${second}" var="lv">
			<tr>
				<td><c:out value="${lv.categoryName}" /></td>
				<td><c:out value="${lv.elementCountInMemory}" /></td>
				<td><c:out value="${lv.elementCountOnDisk}" /></td>
				<td><c:out value="${lv.putCount}" /></td>
				<td><c:out value="${lv.hitCount}" /></td>
				<td><c:out value="${lv.missCount}" /></td>
				<td><c:out value="${lv.sizeInMemory}" /></td>
			</tr>
		</c:forEach>
	</table>

	<h2>Collection Global Info:</h2>
	<h4>
		Fetch Count=
		<c:out value="${cacheform.collectionFetchCount}" />
		&nbsp;:&nbsp;Load Count=
		<c:out value="${cacheform.collectionLoadCount}" />
		&nbsp;:&nbsp;Recreate Count=
		<c:out value="${cacheform.collectionRecreateCount}" />
		&nbsp;:&nbsp;Remove Count=
		<c:out value="${cacheform.collectionRemoveCount}" />
		&nbsp;:&nbsp;Update Count=
		<c:out value="${cacheform.collectionUpdateCount}" />
	</h4>
	<table border="1">
		<tr>
			<td>Category Name</td>
			<td>Fetch Cnt</td>
			<td>Load Cnt</td>
			<td>Recreate Cnt</td>
			<td>Remove Cnt</td>
			<td>Update Cnt</td>
		</tr>
		<c:forEach items="${collect}" var="lv">
			<tr>
				<td><c:out value="${lv.categoryName}" /></td>
				<td><c:out value="${lv.fetchCount}" /></td>
				<td><c:out value="${lv.loadCount}" /></td>
				<td><c:out value="${lv.recreateCount}" /></td>
				<td><c:out value="${lv.removeCount}" /></td>
				<td><c:out value="${lv.updateCount}" /></td>
			</tr>
		</c:forEach>
	</table>

	<h2>Query Cache Info:</h2>
	<h4>
		Put Count=
		<c:out value="${cacheform.queryCachePutCount}" />
		&nbsp;:&nbsp;Hit Count=
		<c:out value="${cacheform.queryCacheHitCount}" />
		&nbsp;:&nbsp;Miss Count=
		<c:out value="${cacheform.queryCacheMissCount}" />
	</h4>
	<h2>Query Execution Global Info:</h2>
	<h4>
		Query Execution Count=
		<c:out value="${cacheform.queryExecutionCount}" />
		&nbsp;:&nbsp;Execution Max Time=
		<c:out value="${cacheform.queryExecutionMaxTime}" />
		<p />
		Execution Max Time String=
		<c:out value="${cacheform.queryExecutionMaxTimeQueryString}" />
	</h4>
	<h2>Each Query Execution Info:</h2>
	<table border="1">
		<tr>
			<td>Name</td>
			<td>Hit Cnt</td>
			<td>Miss Cnt</td>
			<td>Put Cnt</td>
			<td>Execute Avg</td>
			<td>Execute Cnt</td>
			<td>Execute Max</td>
			<td>Execute Min</td>
			<td>Execute Row Cnt</td>
		</tr>
		<c:forEach items="${query}" var="lv">
			<tr>
				<td><c:out value="${lv.categoryName}" /></td>
				<td><c:out value="${lv.cacheHitCount}" /></td>
				<td><c:out value="${lv.cacheMissCount}" /></td>
				<td><c:out value="${lv.cachePutCount}" /></td>
				<td><c:out value="${lv.executionAvgTime}" /></td>
				<td><c:out value="${lv.executionCount}" /></td>
				<td><c:out value="${lv.executionMaxTime}" /></td>
				<td><c:out value="${lv.executionMinTime}" /></td>
				<td><c:out value="${lv.executionRowCount}" /></td>
			</tr>
		</c:forEach>
	</table>
	<h1>Entity Global Info:</h1>
	<h4>
		Entity Load Count=
		<c:out value="${cacheform.entityLoadCount}" />
		&nbsp;:&nbsp; Entity Fetch Count=
		<c:out value="${cacheform.entityFetchCount}" />
		&nbsp;:&nbsp; Entity Insert Count=
		<c:out value="${cacheform.entityInsertCount}" />
		&nbsp;:&nbsp; Entity Delete Count=
		<c:out value="${cacheform.entityDeleteCount}" />
		&nbsp;:&nbsp; Entity Update Count=
		<c:out value="${cacheform.entityUpdateCount}" />
		&nbsp;:&nbsp; Optimistic Failure Count=
		<c:out value="${cacheform.entityUpdateCount}" />
	</h4>
	<table border="1">
		<tr>
			<td>Category Name</td>
			<td>Delete Cnt</td>
			<td>Fetch Cnt</td>
			<td>Insert Cnt</td>
			<td>Load Cnt</td>
			<td>Optimistic Failure</td>
			<td>Update Cnt</td>

		</tr>
		<c:forEach items="${entity}" var="lv">
			<tr>
				<td><c:out value="${lv.categoryName}" /></td>
				<td><c:out value="${lv.deleteCount}" /></td>
				<td><c:out value="${lv.fetchCount}" /></td>
				<td><c:out value="${lv.insertCount}" /></td>
				<td><c:out value="${lv.loadCount}" /></td>
				<td><c:out value="${lv.optimisticFailureCount}" /></td>
				<td><c:out value="${lv.updateCount}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
