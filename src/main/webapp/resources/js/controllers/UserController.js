'use strict';

/**
 * TrainController
 * @constructor
 */
var UserController = function($scope, $http) {
    $scope.user = {};
    $scope.editMode = false;

    $scope.fetchUsersList = function() {
        $http.get('users/userslist.json').success(function(userList){
            $scope.users = userList;
        });
    };

    $scope.addNewUser = function(user) {
        $scope.resetError();

        $http.post('users/addUser', user).success(function() {
            $scope.fetchUsersList();
            $scope.user.username = '';
            $scope.user.password = '';
            $scope.user.emailAddress = '';
        }).error(function() {
            $scope.setError('Could not add a new user');
        });
    };

    $scope.updateUser = function(user) {
        $scope.resetError();

        $http.put('users/updateUser', user).success(function() {
            $scope.fetchUsersList();
            $scope.user.username = '';
            $scope.user.emailAddress = '';
            $scope.user.password = '';
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the user');
        });
    };

    $scope.editUser = function(user) {
        $scope.resetError();
        $scope.user = user;
        $scope.editMode = true;
    };

    $scope.removeUser = function(id) {
        $scope.resetError();

        $http.delete('users/removeUser/' + id).success(function() {
            $scope.fetchUsersList();
        }).error(function() {
            $scope.setError('Could not remove user');
        });
        $scope.user.username = '';
        $scope.user.emailAddress = '';
        $scope.user.password = '';
    };

    $scope.removeAllUsers = function() {
        $scope.resetError();

        $http.delete('users/removeAllUsers').success(function() {
            $scope.fetchUsersList();
        }).error(function() {
            $scope.setError('Could not remove all users');
        });

    };

    $scope.resetUserForm = function() {
        $scope.resetError();
        $scope.user = {};
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchUsersList();

    $scope.predicate = 'id';
};